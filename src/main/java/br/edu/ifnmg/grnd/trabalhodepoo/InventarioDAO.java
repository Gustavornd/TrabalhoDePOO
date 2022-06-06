/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.trabalhodepoo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class InventarioDAO extends Dao< Inventario, Long> {

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
