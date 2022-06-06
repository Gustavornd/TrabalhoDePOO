/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.repositorio;

import br.edu.ifnmg.grnd.entidade.ContemItem;
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
 * @author gusta
 */
public class ContemItemDAO {
    
      /*
    CREATE TABLE arma (
            idInventario int,
            idItem int
    ); ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */

    public void salvar(ContemItem o) {
        ContemItem contemItem = localizarPorId(o.getInventarioID(), o.getItemGeralID());

        // Novo registro
        if (contemItem == null) {

            // try-with-resources libera recurso ao final do bloco (PreparedStatement)
            try ( PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para inserção de registros
                            obterDeclaracaoInsert())) {

                // Prepara a declaração com os dados do objeto passado
                pstmt.setLong(1, o.getInventarioID());
                pstmt.setLong(2, o.getItemGeralID());

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
    public Boolean excluir(ContemItem o) {
        // Recupera a identidade (chave primária composta) 
        // do objeto a ser excluído
        Long inventarioID = o.getInventarioID();
        Long itemGeralID = o.getItemGeralID();

        // Se há uma identidade válida...
        if (inventarioID != null && inventarioID != 0
                && itemGeralID != null && itemGeralID != 0) {
            // ... tenta preparar uma sentença SQL para a conexão já estabelecida
            try ( PreparedStatement pstmt
                    = ConexaoBd.getConexao().prepareStatement(
                            // Sentença SQL para exclusão de registros
                            getDeclaracaoDelete())) {

                // Prepara a declaração com os dados do objeto passado
                pstmt.setLong(1, o.getInventarioID());
                pstmt.setLong(2, o.getItemGeralID());

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
    public ContemItem localizarPorId(Long inventarioID, Long itemGeralID) {
        // Declara referência para reter o objeto a ser recuperado
        ContemItem objeto = null;

        // Tenta preparar uma sentença SQL para a conexão já estabelecida
        try ( PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        // Sentença SQL para busca por chave primária
                        getDeclaracaoSelectPorId())) {

            // Prepara a declaração com os dados do objeto passado
            pstmt.setLong(1, inventarioID);
            pstmt.setLong(2, itemGeralID);

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
        return "INSERT INTO contemitem(idIventario, idItem) VALUES (?, ?);";
    }

    /**
     * Recupera a sentença SQL específica para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM contemitem WHERE idInventario = ? idItem = ?";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String getDeclaracaoSelectTodos() {
        return "SELECT * FROM contemitem";
    }

    /**
     * Recupera a sentença SQL específica para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String getDeclaracaoSelectTodosItensPorInventario() {
        return "SELECT peso, preco, nome, quantidade, descricao, equipado "
                + "FROM itemgeral a "
                + "INNER JOIN contemitem al "
                + "ON a.id = al.idItemGeral "
                + "WHERE al.idInventario  = ?;";
    }

    /**
     * Recupera a sentença SQL específica para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public String getDeclaracaoDelete() {
        return "DELETE FROM contemitem WHERE idInventario = ? AND idItem = ?";
    }

    /**
     * Cria objeto a partir do registro fornecido pelo banco de dados.
     *
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return Objeto constituído.
     */
    public ContemItem extrairObjeto(ResultSet resultSet) {

        ContemItem contemItem = new ContemItem();

        try {
            contemItem.setInventarioID(resultSet.getLong("idInventario"));
            contemItem.setItemGeralID(resultSet.getLong("idItemGeral"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contemItem;
    }

    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    public List<ContemItem> extrairObjetos(ResultSet resultSet) {

        ArrayList<ContemItem> listaItens = new ArrayList<>();

        try {
            while (resultSet.next()) {
                listaItens.add(extrairObjeto(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContemItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaItens;
    }

}
