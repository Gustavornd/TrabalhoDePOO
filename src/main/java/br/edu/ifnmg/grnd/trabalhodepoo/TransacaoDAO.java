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
public class TransacaoDAO extends Dao<Transacao, Long> {

    @Override
    public String obterSentencaInsert() {
        return "insert into transacao (valor, descricao) values (?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update trasacao set valor = ?, descricao = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, valor, descricao from transacao where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, valor, descricao from transacao where excluido = false;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Transacao e) {
        try {
            pstmt.setDouble(1, e.getValor());
            pstmt.setString(2, e.getDescricao());

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(3, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    @Override
    public Transacao extrairObjeto(ResultSet resultSet) {

        Transacao tr = new Transacao();

        try {
            tr.setId(resultSet.getLong("id"));
            tr.setValor(resultSet.getDouble("valor"));
            tr.setDescricao(resultSet.getString("descricao"));
        } catch (SQLException ex) {
            Logger.getLogger(Transacao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return tr;
    }

}