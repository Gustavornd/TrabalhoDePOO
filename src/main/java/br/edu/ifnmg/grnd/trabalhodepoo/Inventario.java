/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.trabalhodepoo;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Inventario {
    
      private Integer totalitems;
      ArrayList<Transacao> listaTrans = new ArrayList<Transacao>();
      ArrayList<ItemGeral> listaItens = new ArrayList<ItemGeral>();

    public Inventario() {
        
    }

    public Inventario(Integer totalitems) {
        this.totalitems = totalitems;
    }

    public Integer getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(Integer totalitems) {
        this.totalitems = totalitems;
    }

    public ArrayList<Transacao> getListaTrans() {
        return listaTrans;
    }

    public void setListaTrans(ArrayList<Transacao> listaTrans) {
        this.listaTrans = listaTrans;
    }

    public ArrayList<ItemGeral> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<ItemGeral> listaItens) {
        this.listaItens = listaItens;
    }
      
    
}
