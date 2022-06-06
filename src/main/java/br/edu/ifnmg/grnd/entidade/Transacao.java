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
 * Entidade que representa uma Transacao.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
public class Transacao extends Entidade {

    private Double valor;
    private String descricao;
//<editor-fold defaultstate="collapsed" desc="Contructors">

    public Transacao() {
    }

    public Transacao(Double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
//</editor-fold>

    @Override
    public String toString() {
        return " Valor = " + valor
                + "\n Descricao = " + descricao;
    }
}
