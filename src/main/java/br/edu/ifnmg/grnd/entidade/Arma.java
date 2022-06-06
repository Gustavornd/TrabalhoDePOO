/*
 * Copyright (C) 2022 gusta
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.edu.ifnmg.grnd.entidade;

import java.util.ArrayList;

/**
 * Entidade que implementa uma subclasse de ItemGeral;
 * 
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
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
