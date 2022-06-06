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
public class Inventario extends Entidade {

    private Integer totalitens;
    ArrayList<Transacao> listaTrans = new ArrayList<Transacao>();
    ArrayList<ItemGeral> listaItens = new ArrayList<ItemGeral>();

    public Inventario() {

    }

    public Inventario(Integer totalitens) {
        this.totalitens = totalitens;
    }

    public Integer getTotalitems() {
        return totalitens;
    }

    public void setTotalitems(Integer totalitens) {
        this.totalitens = totalitens;
    }

    public ArrayList<Transacao> getListaTrans() {
        return listaTrans;
    }

    public void addTrans(Transacao aux) {
        this.listaTrans.add(aux);
    }

    public ArrayList<ItemGeral> getListaItens() {
        return listaItens;
    }

    public void addItens(ItemGeral aux) {
        this.listaItens.add(aux);
        this.totalitens = this.listaItens.size();
    }

    public String listarTrans() {
        for (int i = 0; i < listaTrans.size(); i++) {
            System.out.println(listaTrans.get(i).toString());
        }
        return null;
    }

    public String listarItens() {
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println(listaItens.get(i).toString());
        }
        return null;
    }

    public ItemGeral buscarItem(String a) {
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getNome().equals(a) ) {
                return listaItens.get(i);
            }
        }
        System.out.println("Item nao encontrado.");
        return null;
    }

    public void removeItem(String a) {
        listaItens.remove(buscarItem(a));

    }

    @Override
    public String toString() {
        return "Inventario{" + "totalitens=" + totalitens + '}';
    }
    
    

}

