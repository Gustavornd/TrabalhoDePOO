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
public class ArmaduraDAO extends Dao <Armadura, Long>{
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
	public void montarDeclaracao(PreparedStatement pstmt, Armadura e) {
		try {
		    pstmt.setString(1, e.getTipo());
		    pstmt.setInt(2, e.getDefesa());
		    pstmt.setLong(3, new ItemGeralDAO().salvar(e) );

		    if (e.getId() != null && e.getId() != 0) {
			pstmt.setLong(7, e.getId());
		    }

		} catch (Exception ex) {
		    System.out.println("Exceptoin: " + ex);
		}
	    }


	    @Override
	    public Armadura extrairObjeto(ResultSet resultSet) {
		Armadura e = new Armadura();

		try {
                                                        e.setTipo(resultSet.getString("tipo"));
                                                        e.setDefesa(resultSet.getInt("defesa"));
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
