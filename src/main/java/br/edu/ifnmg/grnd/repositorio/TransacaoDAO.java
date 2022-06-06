/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.grnd.repositorio;

import br.edu.ifnmg.grnd.entidade.Transacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operações concretas que suportam os procedimentos CRUD em objetos em banco de
 * dados.
 *
 * @author lucas
 */
public class TransacaoDAO extends Dao<Transacao, Long> {

    /*
    CREATE TABLE `transacao` (
        `valor` float,
        `descricao` varchar(255),
        `id` int AUTO_INCREMENT,
        PRIMARY KEY (`id`),
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into transacao (valor, descricao) values (?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update trasacao set valor = ?, descricao = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, valor, descricao from transacao where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, valor, descricao from transacao where excluido = false;";
    }
    
    @Override
    public String obterSentencaMoverParaLixeira(){
        return "update transacao set excluido = TRUE where id = ?;";
    }
    
    @Override
     public String getDeclaracaoDelete() {
         return "delete from transacao where id = ?";
     }


    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Transacao e) {
        try {
            pstmt.setDouble(1, e.getValor());
            pstmt.setString(2, e.getDescricao());

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(3, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    /**
     * Extrai um objeto Transacao do resultado gerado pela consulta
     *
     * @param resultSet Registro recuperado do banco de dados
     * @return Transacao equivalente ao registro recebido
     */
    @Override
    public Transacao extrairObjeto(ResultSet resultSet) {

        Transacao tr = new Transacao();

        try {
            tr.setId(resultSet.getLong("id"));
            tr.setValor(resultSet.getDouble("valor"));
            tr.setDescricao(resultSet.getString("descricao"));
        } catch (SQLException ex) {
            Logger.getLogger(Transacao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return tr;
    }

}
