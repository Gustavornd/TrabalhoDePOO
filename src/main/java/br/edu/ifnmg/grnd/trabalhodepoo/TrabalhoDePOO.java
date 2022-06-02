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
	
	    ItemGeral item1 = new ItemGeral();
	    item1.setPeso(3.5);
	    item1.setPreco(30.0);
	    item1.setNome("Braceletes de Prata");
	    item1.setQuantidade(1);
	    item1.setDescricao("Braceletes de prata dados para um guerreiro de honra.");
	    item1.setEquipado(Boolean.TRUE);
	    
	    System.out.println(item1.toString());
	    
	    new ItemGeralDAO().salvar(item1);
    }
}
