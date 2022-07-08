
package br.edu.ifnmg.grnd.repositorio;

import br.edu.ifnmg.grnd.entidade.Usuario;
import br.edu.ifnmg.grnd.repositorio.ConexaoBd;
import br.edu.ifnmg.grnd.repositorio.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe UsuarioDao
 * 
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
public class UsuarioDAO extends Dao<Usuario, Long>{
    
    private static final String SALT = "1FnM6";

     /**
      CREATE TABLE `usuario` (
 *      `id` bigint(20) NOT NULL AUTO_INCREMENT,
 *      `nomesistema` varchar(50) NOT NULL,
 *      `senha` char(32) NOT NULL,
 *      `admin` tinyint(1) DEFAULT '0', -- Administrador?
 *      PRIMARY KEY (`id`),
 *      UNIQUE KEY `nomesistema` (`nomesistema`)
 *      ); 
      */
   
    @Override
    public String obterSentencaInsert() {
        return "insert into usuario (id, nomesistema, senha, admin) values (default, ?, md5(concat('" + SALT + "', ?)), ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Usuario e) {

        try {
            pstmt.setString(1, e.getNomeSistema());
            pstmt.setString(2, e.getSenha());
            pstmt.setBoolean(3, e.getAdministrador());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO Implementar atualizar: depende da respectiva SQL
        if (e.getId() != null && e.getId() != 0) {

        }
    }

    @Override
    public Usuario extrairObjeto(ResultSet resultSet) {
        Usuario resposta = new Usuario();
        try {
            resposta.setId(resultSet.getLong("id"));
            resposta.setNomeSistema(resultSet.getString("nomesistema"));
            resposta.setSenha(null);  
            resposta.setAdministrador(resultSet.getBoolean("admin"));

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }

    public Usuario autenticar(Usuario usuario) {

        Usuario resposta = null;

        // Validação de usuario
        try ( PreparedStatement preparedStatement
                = ConexaoBd.getConexao().prepareStatement("select * from usuario where nomesistema = ? and senha = md5(concat('" + SALT + "', ?));")) {
            
            preparedStatement.setString(1, usuario.getNomeSistema());
            preparedStatement.setString(2, usuario.getSenha());

            // Recupera os dados da consulta
            ResultSet resultSet
                    = preparedStatement.executeQuery();

            // Movimenta para o primeiro dado recuperado
            if (resultSet.next()) {
                // Extrai o objeto representado pelo registro recuperado
                return extrairObjeto(resultSet);
            }

        } catch (Exception ex) {
            System.out.println(">> " + ex);
        }

        return resposta;
    }

    @Override
    public String obterSentencaMoverParaLixeira() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeclaracaoDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}