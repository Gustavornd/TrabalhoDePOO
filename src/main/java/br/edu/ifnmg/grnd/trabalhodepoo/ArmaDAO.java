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
public class ArmaDAO extends Dao <Arma, Long> {
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
	public void montarDeclaracao(PreparedStatement pstmt, Arma e) {
		try {
		    pstmt.setInt(1, e.getAlcance().get(0));
		    pstmt.setInt(2, e.getAlcance().get(1));
		    pstmt.setInt(3, e.getDano().get(0));
                                                pstmt.setInt(4, e.getDano().get(1));
		    pstmt.setLong(5, new ItemGeralDAO().salvar(e) );

		    if (e.getId() != null && e.getId() != 0) {
			pstmt.setLong(7, e.getId());
		    }

		} catch (Exception ex) {
		    System.out.println("Exceptoin: " + ex);
		}
	    }


	    @Override
	    public Arma extrairObjeto(ResultSet resultSet) {
		Arma e = new Arma();

		try {
                                                        e.setAlcance(resultSet.getInt("alcance_effective"), resultSet.getInt("alcance_max"));
                                                        e.setDano(resultSet.getInt("dano_roll"), resultSet.getInt("dano_dice"));
                                                        ItemGeral aux =  new ItemGeralDAO().localizarPorId(resultSet.getLong("idItemGeral"));
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
