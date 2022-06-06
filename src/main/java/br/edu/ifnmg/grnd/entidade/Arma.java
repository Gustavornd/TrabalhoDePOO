/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.entidade;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Arma extends ItemGeral {

    ArrayList<Integer> dano = new ArrayList<Integer>();
    ArrayList<Integer> alcance = new ArrayList<Integer>();

    //<editor-fold defaultstate="collapsed" desc="Contructor">
    public Arma() {
        this.dano.add(0, 0);
        this.dano.add(1, 0);
        this.alcance.add(0, 0);
        this.alcance.add(1, 0);
    }

    public Arma(Integer rolls, Integer dice, Integer effective, Integer max, Double peso, Double preco, Integer quantidade, String descricao, String nome, Boolean equipado) {
        super(peso, preco, quantidade, descricao, nome, equipado);
        this.dano.add(0, rolls);
        this.dano.add(1, dice);
        this.alcance.add(0, effective);
        this.alcance.add(1, max);
    }
    //</editor-fold>	
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public ArrayList<Integer> getDano() {
        return dano;
    }

    public void setDano(Integer rolls, Integer dice) {
        this.dano.add(0, rolls);
        this.dano.add(1, dice);
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
        return super.toString() + "Dano: " + dano.get(0) + " d" + dano.get(1) + "\n"
                + "Alcance: " + alcance.get(0) + "/" + alcance.get(1) + "\n";
    }

}
