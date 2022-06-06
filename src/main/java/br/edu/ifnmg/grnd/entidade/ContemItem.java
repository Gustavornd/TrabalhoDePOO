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
 * Entidade que representa a associação entre
 * Inventario e ItemGeral e demais subclasses;
 * 
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
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
