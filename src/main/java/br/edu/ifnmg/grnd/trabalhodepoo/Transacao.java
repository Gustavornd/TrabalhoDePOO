/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.trabalhodepoo;

/**
 *
 * @author lucas
 */
public class Transacao {
    
    private Double valor;
    private String descricao;

    public Transacao() {
    }

    public Transacao(Double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

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

    @Override
 public String toString(){
     return "Valor = " + valor + "/n" +
            "Descricao = " + descricao; 
 }   
}
