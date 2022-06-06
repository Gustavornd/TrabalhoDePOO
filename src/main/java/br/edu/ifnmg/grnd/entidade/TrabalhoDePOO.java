/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package br.edu.ifnmg.grnd.entidade;

import br.edu.ifnmg.grnd.repositorio.TransacaoDAO;
import br.edu.ifnmg.grnd.repositorio.ArmaDAO;
import br.edu.ifnmg.grnd.repositorio.ArmaduraDAO;
import br.edu.ifnmg.grnd.repositorio.ConsumivelDAO;
import br.edu.ifnmg.grnd.repositorio.ContemItemDAO;
import br.edu.ifnmg.grnd.repositorio.ContemTransacaoDAO;
import br.edu.ifnmg.grnd.repositorio.InventarioDAO;
import br.edu.ifnmg.grnd.repositorio.ItemGeralDAO;
import br.edu.ifnmg.grnd.repositorio.PersonagemDAO;

/**
 *
 * @author gusta
 */
public class TrabalhoDePOO {

    public static void main(String[] args) {
        Transacao trans1 = new Transacao(-300.00, "Tiltei e comprei o puteiro");
        new TransacaoDAO().salvar(trans1);

    }
}
