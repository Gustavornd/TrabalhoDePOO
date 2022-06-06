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
 * @author gusta
 */
public class ItemGeralDAO extends Dao<ItemGeral, Long> {

    @Override
    public String obterSentencaInsert() {
        return "insert into itemgeral (peso, preco, nome, quantidade, descricao, equipado) values (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update itemgeral set peso = ?, preco = ?, nome = ?, quantidade = ?, descricao = ?, equipado = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, peso, preco, nome, quantidade, descricao, equipado from itemgeral where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, peso, preco, nome, quantidade, descricao, equipado from itemgeral where excluido = false;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "delete from personagem where id = ?";
    }

    @Override
    public String obterSentencaMoverParaLixeira() {
        return "update itemgeral set excluido = TRUE where id = ?;";
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, ItemGeral e) {
        try {
            pstmt.setDouble(1, e.getPeso());
            pstmt.setDouble(2, e.getPreco());
            pstmt.setString(3, e.getNome());
            pstmt.setInt(4, e.getQuantidade());
            pstmt.setString(5, e.getDescricao());
            pstmt.setBoolean(6, e.getEquipado());

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(7, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    @Override
    public ItemGeral extrairObjeto(ResultSet resultSet) {
        ItemGeral ig = new ItemGeral();

        try {
            ig.setId(resultSet.getLong("id"));
            ig.setPeso(resultSet.getDouble("peso"));
            ig.setPreco(resultSet.getDouble("preco"));
            ig.setQuantidade(resultSet.getInt("quantidade"));
            ig.setDescricao(resultSet.getString("descricao"));
            ig.setNome(resultSet.getString("nome"));
            ig.setEquipado(resultSet.getBoolean("equipado"));

        } catch (SQLException ex) {
            Logger.getLogger(ItemGeral.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ig;
    }

}
