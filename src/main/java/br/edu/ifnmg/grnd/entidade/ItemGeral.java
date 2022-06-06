/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
	
package br.edu.ifnmg.grnd.entidade;



/**
 *
 * @author gusta
 */
public class ItemGeral extends Entidade{
	private Double peso;
	private Double preco;
	private Integer quantidade;
	private String descricao;
	private String nome;
	private Boolean equipado;
	//<editor-fold defaultstate="collapsed" desc="Contructors">
    

    public ItemGeral() {
		this.peso = 0.0;
		this.preco = 0.0;
		this.quantidade = 0;
		this.descricao = null;
		this.nome = null;
	}

	public ItemGeral(Double peso, Double preco, Integer quantidade, String descricao, String nome, Boolean equipado) {
		this.peso = peso;
		this.preco = preco;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.nome = nome;
		this.equipado = equipado;
	}
//</editor-fold>
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getEquipado() {
		return equipado;
	}

	public void setEquipado(Boolean equipado) {
		this.equipado = equipado;
	}
//</editor-fold>
	
	
	
	@Override
	public String toString() {
		return "Peso: " + peso + "\n" +
			"Preco: " + preco + "\n" +
			"Quantidade: " + quantidade + "\n" +
			"Descricao: " + descricao + "\n" +
			"Nome: " + nome + "\n" +
			"Equipado: " + equipado + "\n";
	}
	
	
	
	
    
}
