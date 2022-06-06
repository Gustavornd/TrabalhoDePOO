/*
 * Copyright (C) 2022 gusta
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.edu.ifnmg.grnd.repositorio;

import br.edu.ifnmg.grnd.entidade.ContemTransacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações concretas que suportam os procedimentos CRUD em objetos em banco de
 * dados.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */

public class ContemTransacaoDAO {
    
    /*
    CREATE TABLE arma (
            idInventario int,
            idTransacao int
    ); ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    
    public void salvar(ContemTransacao o){
       ContemTransacao contemtrans= localizarPorId(o.getInventarioID(), o.getTransacaoID());
       
       // Novo registro
        if (contemtrans == null) {

            // try-with-resources libera recurso ao final do bloco (PreparedStatement)
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para inserção de registros
                            obterDeclaracaoInsert())) {

                // Prepara a declaração com os dados do objeto passado
                pstmt.setLong(1, o.getInventarioID());
                pstmt.setLong(2, o.getTransacaoID());

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
            
    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param o Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    public Boolean excluir(ContemTransacao o) {
        // Recupera a identidade (chave primária composta) 
        // do objeto a ser excluído
        Long inventarioID = o.getInventarioID();
        Long transacaoID = o.getTransacaoID();

        // Se há uma identidade válida...
        if (inventarioID != null && inventarioID != 0
                && transacaoID != null && transacaoID != 0) {
            // ... tenta preparar uma sentença SQL para a conexão já estabelecida
            try (PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para exclusão de registros
                            getDeclaracaoDelete())) {

                // Prepara a declaração com os dados do objeto passado
                pstmt.setLong(1, o.getInventarioID());
                pstmt.setLong(2, o.getTransacaoID());

                // Executa o comando SQL
                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return false;
        }

        return true;
    }

    /**
     * Recupera um dado objeto mapeado para o banco de dados por meio de sua
     * chave de identidade.
     *
     * @param id Identidade do objeto.
     * @return Objeto segundo registro persistido.
     */
    public ContemTransacao localizarPorId(Long inventarioID, Long transacaoID) {
        // Declara referência para reter o objeto a ser recuperado
        ContemTransacao objeto = null;

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para busca por chave primária
                        getDeclaracaoSelectPorId())) {

            // Prepara a declaração com os dados do objeto passado
            pstmt.setLong(1, inventarioID);
            pstmt.setLong(2, transacaoID);

            // Executa o comando SQL
            ResultSet resultSet = pstmt.executeQuery();

            // Se há resultado retornado...
            if (resultSet.next()) {
                // ... extrai objeto do respectivo registro do banco de dados
                objeto = extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Devolve nulo (objeto não encontrado) ou o objeto recuperado
        return objeto;
    }

    
    /**
     * Recupera a sentença SQL específica para a inserção da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para inserção.
     */
    public String obterDeclaracaoInsert() {
        return "INSERT INTO contemtrans(idIventario, idTransacao) VALUES (?, ?);";
    }

    /**
     * Recupera a sentença SQL específica para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM contemtrans WHERE idInventario = ? idTransacao = ?";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM contemtrans";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String getDeclaracaoSelectTodosItensPorInventario() {
        return "SELECT valor, descricao " 
                + "FROM transacao a "
                + "INNER JOIN contemtrans al "
                + "ON a.id = al.idTransacao "
                + "WHERE al.idInventario  = ?;";
    }


    /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public String getDeclaracaoDelete() {
        return "DELETE FROM contemtrans WHERE idInventario = ? AND idTransacao = ?";
    }

    /**
     * Cria objeto a partir do registro fornecido pelo banco de dados.
     *
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return Objeto constituído.
     */
    public ContemTransacao extrairObjeto(ResultSet resultSet) {

        ContemTransacao contemtrans = new ContemTransacao();

        try {
            contemtrans.setInventarioID(resultSet.getLong("idInventario"));
            contemtrans.setTransacaoID(resultSet.getLong("idTransacao"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return contemtrans;
    }

    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    public List<ContemTransacao> extrairObjetos(ResultSet resultSet) {


        ArrayList<ContemTransacao> listaTrans = new ArrayList<>();


        try {
            while (resultSet.next()) {
                listaTrans.add(extrairObjeto(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContemTransacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return listaTrans;
    }
    
}
