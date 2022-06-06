/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.repositorio;

import br.edu.ifnmg.grnd.entidade.Arma;
import br.edu.ifnmg.grnd.entidade.ItemGeral;
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
public class ArmaDAO extends Dao<Arma, Long> {

    /*
    CREATE TABLE arma (
        `alcance_effective` int,
        `alcance_max` int,
        `dano_roll` int,
        `dano_dice` int,
        `id` int AUTO_INCREMENT,
        PRIMARY KEY (`id`),
        `idItemGeral` int,
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into arma(alcance_effective, alcance_max, dano_roll, dano_dice, idItemGeral) values (?, ?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update arma set alcance_effective = ?, alcance_max = ?, dano_roll = ?, dano_dice = ?, idItemGeral = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, alcance_effective, alcance_max, dano_roll, dano_dice, idItemGeral from arma where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, alcance_effective, alcance_max, dano_roll, dano_dice, idItemGeral from arma where excluido = false;";
    }
    
    
    
    @Override
    public String getDeclaracaoDelete() {
        return "delete from arma where id = ?";
     }
    
    @Override
    public String obterSentencaMoverParaLixeira() {
        return "update arma set excluido = TRUE where id = ?;";
    }
    

    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Arma e) {
        try {
            pstmt.setInt(1, e.getAlcance().get(0));
            pstmt.setInt(2, e.getAlcance().get(1));
            pstmt.setInt(3, e.getDano().get(0));
            pstmt.setInt(4, e.getDano().get(1));
            pstmt.setLong(5, new ItemGeralDAO().salvar(e));

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
    public Arma extrairObjeto(ResultSet resultSet) {
        Arma e = new Arma();

        try {
            e.setAlcance(resultSet.getInt("alcance_effective"), resultSet.getInt("alcance_max"));
            e.setDano(resultSet.getInt("dano_roll"), resultSet.getInt("dano_dice"));
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
