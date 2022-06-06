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

import br.edu.ifnmg.grnd.entidade.Armadura;
import br.edu.ifnmg.grnd.entidade.ItemGeral;
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
public class ArmaduraDAO extends Dao<Armadura, Long> {

    /*
    CREATE TABLE armadura (
        `tipo` varchar(255),
        `defesa` int,
        `id` int AUTO_INCREMENT,
        PRIMARY KEY (`id`),
        `idItemGeral` int,
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into armadura(tipo, defesa, idItemGeral)  values (?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update armadura set tipo = ?, defesa = ?, idItemGeral = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, tipo, defesa, idItemGeral from armadura where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, tipo, defesa, idItemGeral from armadura where excluido = false;";
    }

    @Override
    public String getDeclaracaoDelete() {
        return "delete from armadura where id = ?";
    }

    @Override
    public String obterSentencaMoverParaLixeira() {
        return "update armadura set excluido = TRUE where id = ?;";
    }

    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Armadura e) {
        try {
            pstmt.setString(1, e.getTipo());
            pstmt.setInt(2, e.getDefesa());
            pstmt.setLong(3, new ItemGeralDAO().salvar(e));

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(7, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    /**
     * Extrai um objeto Arma do resultado gerado pela consulta
     *
     * @param resultSet Registro recuperado do banco de dados
     * @return Arma equivalente ao registro recebido
     */
    @Override
    public Armadura extrairObjeto(ResultSet resultSet) {
        Armadura e = new Armadura();

        try {
            e.setTipo(resultSet.getString("tipo"));
            e.setDefesa(resultSet.getInt("defesa"));
            ItemGeral aux = new ItemGeralDAO().localizarPorId(resultSet.getLong("idItemGeral"));
            e.setDescricao(aux.getDescricao());
            e.setNome(aux.getNome());
            e.setPreco(aux.getPreco());
            e.setPeso(aux.getPeso());
            e.setEquipado(aux.getEquipado());
            e.setQuantidade(aux.getQuantidade());

        } catch (SQLException ex) {
            Logger.getLogger(ItemGeral.class.getName()).log(Level.SEVERE, null, ex);
        }

        return e;
    }

}
