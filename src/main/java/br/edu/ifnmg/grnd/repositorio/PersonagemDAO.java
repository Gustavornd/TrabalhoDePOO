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

/*
 *  Operações concretas que suportam os procedimentos CRUD em objetos em banco de
 * dados.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
import br.edu.ifnmg.grnd.entidade.Inventario;
import br.edu.ifnmg.grnd.entidade.Personagem;
import br.edu.ifnmg.grnd.repositorio.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonagemDAO extends Dao<Personagem, Long> {

    /*
    CREATE TABLE personagem (
        `id` int NOT NULL AUTO_INCREMENT,
        `nome` varchar(200),
        `limPeso` float,
        `dinheiro` float,
        `ca` int,
        `inventario` int,
        PRIMARY KEY (`id`),
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into personagem (nome, limPeso, dinheiro, ca, inventarioid) values (?, ?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update personagem set nome = ?, limPeso = ?, dinheiro = ?, ca = ?, inventarioid = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, nome, limPeso, dinheiro, ca, inventarioid from personagem where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, nome, limPeso, dinheiro, ca, inventarioid from personagem where excluido = false;";
    }
    
    @Override
    public String getDeclaracaoDelete() {
        return "delete from personagem where id = ?";
    }
   

    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Personagem e) {
        try {
            pstmt.setString(1, e.getNome());
            pstmt.setDouble(2, e.getLimPeso());
            pstmt.setDouble(3, e.getDinheiro());
            pstmt.setInt(4, e.getCa());
            pstmt.setInt(5, e.getInventario()); //new InventarioDAO().salvar(e.getInventario()));

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(6, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    /**
     * Extrai um objeto Personagem do resultado gerado pela consulta
     *
     * @param resultSet Registro recuperado do banco de dados
     * @return Personagem equivalente ao registro recebido
     */
    @Override
    public Personagem extrairObjeto(ResultSet resultSet) {
        Personagem pr = new Personagem();

        try {
            pr.setId(resultSet.getLong("id"));
            pr.setNome(resultSet.getString("nome"));
            pr.setLimPeso(resultSet.getDouble("limPeso"));
            pr.setDinheiro(resultSet.getDouble("dinheiro"));
            pr.setCa(resultSet.getInt("ca"));
            pr.setInventario(resultSet.getInt("inventarioid"));
            //Inventario inv = new InventarioDAO().localizarPorId(resultSet.getLong("inventario"));
            //pr.setInventario(inv);

        } catch (SQLException ex) {
            Logger.getLogger(PersonagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pr;
    }

    @Override
    public String obterSentencaMoverParaLixeira() {
        return "update personagem set excluido = TRUE where id = ?;";
    }



}
