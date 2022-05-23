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
	    ItemGeral item = new ItemGeral(1.0, 10.00, 1, "Uma mochila de couro para seus itens.", "Mochila", false);
	    System.out.println(item.toString() + "\nXXXXXXXXXXXXXXXXXXXXX\n");
	    
	    Armadura item2 = new Armadura ("Couro", 2, 6.0, 70.00, 1, "Uma armadura de couro.", "Peitoral de couro", true );    
	    System.out.println(item2.toString() + "\nXXXXXXXXXXXXXXXXXXXXX\n");
	    
	    Arma item3 = new Arma(1, 6, 10, 20, 4.0, 200.00, 1, "Uma espada comum de metal.", "Espada de Metal", true);
	    System.out.println(item3.toString() + "\nXXXXXXXXXXXXXXXXXXXXX\n");
	    
	    Consumivel item4 = new Consumivel(1, 3, 5, 0.5, 1.00, 2, "Uma tocha para iluminar seu caminho", "Tocha", false);
	    System.out.println(item4.toString() + "\nXXXXXXXXXXXXXXXXXXXXX\n");
		    
	    
}}
