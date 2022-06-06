/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.trabalhodepoo;

/**
 * Entidade que representa uma Transacao.
 *
 * @author lucas
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
