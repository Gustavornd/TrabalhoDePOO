/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.entidade;

/**
 * Entidade que representa a associação entre
 * Inventario e ItemGeral e demais subclasses;
 * 
 * @author gusta
 */
public class ContemItem {

    private Long inventarioID;
    private Long itemGeralID;

    public ContemItem() {
    }

    public ContemItem(Long inventarioID, Long itemGeralID) {
        this.inventarioID = inventarioID;
        this.itemGeralID = itemGeralID;
    }

    public Long getInventarioID() {
        return inventarioID;
    }

    public void setInventarioID(Long inventarioID) {
        this.inventarioID = inventarioID;
    }

    public Long getItemGeralID() {
        return itemGeralID;
    }

    public void setItemGeralID(Long itemGeralID) {
        this.itemGeralID = itemGeralID;
    }

    @Override
    public String toString() {
        return "ContemItem{" + "inventarioID=" + inventarioID + ", itemGeralID=" + itemGeralID + '}';
    }

}
