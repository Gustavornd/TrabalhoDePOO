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

/**
 * Entidade que implementa uma subclasse de ItemGeral;
 * 
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
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
        return super.toString() + "Tipo: " + tipo + "\n"
                + "Defesa: " + defesa + "\n";
    }

}
