/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.trabalhodepoo;

/**
 *
 * @author gusta
 */
public class Armadura extends ItemGeral {
	private String tipo;
	private Integer defesa;
	
	//<editor-fold defaultstate="collapsed" desc="Constructor">

	public Armadura() {
		this.tipo = null;
		this.defesa = 0;
	}
	

	public Armadura(String tipo, Integer defesa, Double peso, Double preco, Integer quantidade, String descricao, String nome, Boolean equipado) {
		super(peso, preco, quantidade, descricao, nome, equipado);
		this.tipo = tipo;
		this.defesa = defesa;
	}
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="Getters and Setters">
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	//</editor-fold>
	
	@Override
	public String toString() {
		return super.toString() + "Tipo: " + tipo + "\n" +
			"Defesa: " + defesa + "\n"; 
	}
	
	
}
