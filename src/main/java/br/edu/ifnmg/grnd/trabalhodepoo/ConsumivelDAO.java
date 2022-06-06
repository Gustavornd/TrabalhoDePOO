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
public class ConsumivelDAO extends Dao <Consumivel, Long>{
       @Override
	public String obterSentencaInsert() {
		return "insert into consumivel(duracao, alcance_effective, alcance_max, idItemGeral) values (?, ?, ?, ?);";
	}

	@Override
	public String obterSentencaUpdate() {
		return "update consumivel set duracao = ?, alcance_effective = ?, alcance_max = ?, idItemGeral = ? where id = ?;";
	}

	@Override
	 public String obterSentencaLocalizarPorId() {
		return "select id, duracao, alcance_effective, alcance_max, idItemGeral from consumivel where id = ?;";
	 }

	@Override
	public String obterSentencaLocalizarTodos() {
		return "select id, duracao, alcance_effective, alcance_max, idItemGeral from consumivel where excluido = false;";
	 }
    
                  @Override
	public void montarDeclaracao(PreparedStatement pstmt, Consumivel e) {
		try {
                                        pstmt.setInt(1, e.getDuracao());
		    pstmt.setInt(2, e.getAlcance().get(0));
		    pstmt.setInt(3, e.getAlcance().get(1));
		    pstmt.setLong(4, new ItemGeralDAO().salvar(e) );

		    if (e.getId() != null && e.getId() != 0) {
			pstmt.setLong(7, e.getId());
		    }

		} catch (Exception ex) {
		    System.out.println("Exceptoin: " + ex);
		}
	    }


	    @Override
	    public Consumivel extrairObjeto(ResultSet resultSet) {
		Consumivel e = new Consumivel();

		try {
                                                        e.setDuracao(resultSet.getInt("duracao"));
                                                        e.setAlcance(resultSet.getInt("alcance_effective"), resultSet.getInt("alcance_max"));
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
