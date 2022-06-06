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


}
