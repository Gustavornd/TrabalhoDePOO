
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

import br.edu.ifnmg.grnd.interfac.AutenticarJF;
import br.edu.ifnmg.grnd.repositorio.TransacaoDAO;
import br.edu.ifnmg.grnd.repositorio.ArmaDAO;
import br.edu.ifnmg.grnd.repositorio.ArmaduraDAO;
import br.edu.ifnmg.grnd.repositorio.ConsumivelDAO;
import br.edu.ifnmg.grnd.repositorio.ContemItemDAO;
import br.edu.ifnmg.grnd.repositorio.ContemTransacaoDAO;
import br.edu.ifnmg.grnd.repositorio.InventarioDAO;
import br.edu.ifnmg.grnd.repositorio.ItemGeralDAO;
import br.edu.ifnmg.grnd.repositorio.PersonagemDAO;
import br.edu.ifnmg.grnd.repositorio.UsuarioDAO;

/**
 * Classe de implementação do médoto main();
 * 
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
public class TrabalhoDePOO {

    public static void main(String[] args) {
        /*Transacao trans1 = new Transacao(-300.00, "Tiltei e comprei o puteiro");
        new TransacaoDAO().salvar(trans1);
        */
         Usuario u = new Usuario();
         UsuarioDAO user = new UsuarioDAO();
        u.setNomeSistema("rpginventario");
        u.setSenha("vongola");
        u.setAdministrador(Boolean.TRUE);
        
        user.salvar(u);
        
        Usuario recuperado = new UsuarioDAO().autenticar(u);
        
        if(recuperado != null) {
            System.out.println("Usuário autêntico!");
        } else {
            System.out.println("Acesso não autorizado.");
        }
        
        AutenticarJF obj = new AutenticarJF();
        obj.setVisible(true);
    }
}
