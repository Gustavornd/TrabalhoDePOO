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

package br.edu.ifnmg.grnd.repositorio;

import br.edu.ifnmg.grnd.entidade.Inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações concretas que suportam os procedimentos CRUD em objetos em banco de
 * dados.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
public class InventarioDAO extends Dao< Inventario, Long> {

    /*
    CREATE TABLE `inventario` (
        `id` int AUTO_INCREMENT,
        `totalitens` int,
        PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into inventario (totalitens) values (?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update inventario totalitens = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, totalitens from inventario where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, totalitens from inventario where excluido = false;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "delete from inventario where id = ?";
    }

    @Override
    public String obterSentencaMoverParaLixeira() {
        return "update inventario set excluido = TRUE where id = ?;";
    }

    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Inventario e) {
        try {

            pstmt.setInt(1, e.getTotalitems());

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(2, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    /**
     * Extrai um objeto Inventario do resultado gerado pela consulta
     *
     * @param resultSet Registro recuperado do banco de dados
     * @return Inventario equivalente ao registro recebido
     */
    @Override
    public Inventario extrairObjeto(ResultSet resultSet) {
        Inventario iv = new Inventario();
        try {
            iv.setId(resultSet.getLong("id"));
            iv.setTotalitems(resultSet.getInt("totalitens"));

        } catch (SQLException ex) {
            Logger.getLogger(InventarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return iv;
    }

}
