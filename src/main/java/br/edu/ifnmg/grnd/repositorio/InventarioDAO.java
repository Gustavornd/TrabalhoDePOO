/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.repositorio;

import br.edu.ifnmg.grnd.entidade.Inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações concretas que suportam os procedimentos CRUD em objetos em banco de
 * dados.
 *
 * @author lucas
 */
public class InventarioDAO extends Dao< Inventario, Long> {

    /*
    CREATE TABLE `inventario` (
        `id` int AUTO_INCREMENT,
        `totalitens` int,
        PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into inventario (totalitens) values (?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update inventario totalitens = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, totalitens from inventario where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, totalitens from inventario where excluido = false;";
    }
    
    @Override
    public String getDeclaracaoDelete() {
        return "delete from inventario where id = ?";
    }
    
    @Override
    public String obterSentencaMoverParaLixeira() {
        return "update inventario set excluido = TRUE where id = ?;";
    }

    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Inventario e) {
        try {

            pstmt.setInt(1, e.getTotalitems());

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(2, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    /**
     * Extrai um objeto Inventario do resultado gerado pela consulta
     *
     * @param resultSet Registro recuperado do banco de dados
     * @return Inventario equivalente ao registro recebido
     */

    @Override
    public Inventario extrairObjeto(ResultSet resultSet) {
        Inventario iv = new Inventario();
        try {
            iv.setId(resultSet.getLong("id"));
            iv.setTotalitems(resultSet.getInt("totalitens"));

        } catch (SQLException ex) {
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return iv;
    }

}
