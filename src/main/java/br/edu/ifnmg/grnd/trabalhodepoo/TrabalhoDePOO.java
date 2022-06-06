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
	Transacao trans1 = new TransacaoDAO().localizarPorId(2L);
                  System.out.println(trans1.toString());
                   new TransacaoDAO().moverParaLixeira(trans1);
                  
                  
        
                   
       
            
            
            
            
            
            
    }
}
