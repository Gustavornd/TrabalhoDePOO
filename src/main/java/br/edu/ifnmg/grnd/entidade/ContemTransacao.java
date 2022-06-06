/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.entidade;

/**
 * Entidade que representa a associação entre
 * Inventario e Transacao;
 * 
 * @author gusta
 */
public class ContemTransacao {

    private Long inventarioID;
    private Long transacaoID;

    public ContemTransacao() {
    }

    public ContemTransacao(Long inventarioID, Long transacaoID) {
        this.inventarioID = inventarioID;
        this.transacaoID = transacaoID;
    }

    public Long getInventarioID() {
        return inventarioID;
    }

    public void setInventarioID(Long inventarioID) {
        this.inventarioID = inventarioID;
    }

    public Long getTransacaoID() {
        return transacaoID;
    }

    public void setTransacaoID(Long transacaoID) {
        this.transacaoID = transacaoID;
    }

    @Override
    public String toString() {
        return "ContemTransacao{" + "inventarioID=" + inventarioID + ", transacaoID=" + transacaoID + '}';
    }

}
