
package br.edu.ifnmg.grnd.trabalhodepoo;

/*
Autor: Friedrich Naum
*/

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
        `inventarioid` int,
        PRIMARY KEY (`id`),
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    
    @Override
    public String obterSentencaInsert() {
        return "insert into personagem (nome, limPeso, dinheiro, ca, inventario) values (?, ?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update personagem set nome = ?, limPeso = ?, dinheiro = ?, ca = ?, inventario = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, nome, limPeso, dinheiro, ca, inventario from personagem where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, nome, limPeso, dinheiro, ca, inventario from personagem where excluido = false;";
    }

    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Personagem e) {
        try {
            pstmt.setString(1, e.getNome());
            pstmt.setFloat(2, e.getLimPeso());
            pstmt.setFloat(3, e.getDinheiro());
            pstmt.setInt(4,e.getCa());
            pstmt.setObject(5, e.getInventario());

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(6, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    @Override
    public Personagem extrairObjeto(ResultSet resultSet) {
        Personagem pr = new Personagem();

        try {
            pr.setId(resultSet.getLong("id"));
            pr.setNome(resultSet.getString("nome"));
            pr.setLimPeso(resultSet.getFloat("limPeso"));
            pr.setDinheiro(resultSet.getFloat("dinheiro"));
            pr.setCa(resultSet.getInt("ca"));
            pr.setInventario(resultSet.getObject("inventario", Inventario.class));

        } catch (SQLException ex) {
            Logger.getLogger(PersonagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pr;
    }
    
    
}
