/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.ifnmg.grnd.trabalhodepoo;



/**
 *
 * @author gusta
 */
public class TrabalhoDePOO {

    public static void main(String[] args) {
	Arma arm1 = new ArmaDAO().localizarPorId(2L);
                  Inventario inv1 = new Inventario();
                  inv1.addItens(arm1);
                  
                  inv1.listarItens();
        
                   
       
            
            
            
            
            
            
    }
}
