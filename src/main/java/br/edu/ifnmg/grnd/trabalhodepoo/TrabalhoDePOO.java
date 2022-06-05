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
            
            Inventario inv1 = new Inventario();
            ItemGeral mochila = new ItemGeral(2.00,10.00,1,"mochila para carregar equipamentos","mochila",true);
            
            inv1.addItens(item1);
            inv1.listarItens();
            
            //Testar Personagem
            Inventario inv = new Inventario();
            Personagem pr = new Personagem("Dylan",15.5f,20.0f,15,inv);
            
            new PersonagemDAO().salvar(pr);
            new PersonagemDAO().obterSentencaInsert();
            System.out.println("Personagem: " + pr.toString());
            pr.calcPeso(); // Calculo Do Peso: Mostra o Limite de Peso e o quanto de peso esta sendo usado
            pr.calcMoney(); // Mostra quanto gastou em suas transações e quanto ainda resta de Money
            
            
    }
}
