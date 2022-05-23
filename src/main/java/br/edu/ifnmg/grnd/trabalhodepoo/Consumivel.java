/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.trabalhodepoo;
import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Consumivel extends ItemGeral {
	private Integer duracao;
	private ArrayList<Integer> alcance = new ArrayList<Integer>();

        //<editor-fold defaultstate="collapsed" desc="Constructors">
        

	public Consumivel() {
		this.duracao = 0;
		this.alcance.add(0, 0);
		this.alcance.add(1, 0);
	}
		
	public Consumivel(Integer duracao, Integer effective, Integer max, Double peso, Double preco, Integer quantidade, String descricao, String nome, Boolean equipado) {
		super(peso, preco, quantidade, descricao, nome, equipado);
		this.duracao = duracao;
		this.alcance.add(0, effective);
		this.alcance.add(1, max);
	}
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
        

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public ArrayList<Integer> getAlcance() {
		return alcance;
	}

	public void setAlcance(Integer effective, Integer max) {
		this.alcance.add(0, effective);
		this.alcance.add(1, max);
	}
//</editor-fold>
	@Override
	public String toString() {
		return super.toString() + "Usos: " + duracao + "\n" 
			+ "Alcance: " + alcance.get(0) + "/" + alcance.get(1) + "\n";
	}

        
        /* Essa linha é apenas um teste para ver se consigo dar commit */
        
	
	
	
	
	
	
}
