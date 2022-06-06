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
 * Operações concretas que suportam os procedimentos CRUD em objetos em banco de
 * dados.
 *
 * @author gusta
 */
public class ArmaduraDAO extends Dao<Armadura, Long> {

    /*
    CREATE TABLE armadura (
        `tipo` varchar(255),
        `defesa` int,
        `id` int AUTO_INCREMENT,
        PRIMARY KEY (`id`),
        `idItemGeral` int,
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into armadura(tipo, defesa, idItemGeral)  values (?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update armadura set tipo = ?, defesa = ?, idItemGeral = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, tipo, defesa, idItemGeral from armadura where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, tipo, defesa, idItemGeral from armadura where excluido = false;";
    }
    
    @Override
    public String getDeclaracaoDelete() {
        return "delete from armadura where id = ?";
    }
    
    @Override
    public String obterSentencaMoverParaLixeira() {
        return "update armadura set excluido = TRUE where id = ?;";
    }


    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Armadura e) {
        try {
            pstmt.setString(1, e.getTipo());
            pstmt.setInt(2, e.getDefesa());
            pstmt.setLong(3, new ItemGeralDAO().salvar(e));

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(7, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    /**
     * Extrai um objeto Arma do resultado gerado pela consulta
     *
     * @param resultSet Registro recuperado do banco de dados
     * @return Arma equivalente ao registro recebido
     */

    @Override
    public Armadura extrairObjeto(ResultSet resultSet) {
        Armadura e = new Armadura();

        try {
            e.setTipo(resultSet.getString("tipo"));
            e.setDefesa(resultSet.getInt("defesa"));
            ItemGeral aux = new ItemGeralDAO().localizarPorId(resultSet.getLong("idItemGeral"));
            e.setDescricao(aux.getDescricao());
            e.setNome(aux.getNome());
            e.setPreco(aux.getPreco());
            e.setPeso(aux.getPeso());
            e.setEquipado(aux.getEquipado());
            e.setQuantidade(aux.getQuantidade());

        } catch (SQLException ex) {
            Logger.getLogger(ItemGeral.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;
    }

}
