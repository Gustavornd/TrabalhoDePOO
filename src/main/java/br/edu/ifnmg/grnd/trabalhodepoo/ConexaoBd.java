
package br.edu.ifnmg.grnd.trabalhodepoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBd {

	
	private static Connection conexao;

	
	public static final String URL;

	
	private static final String USUARIO;

	
	private static final String SENHA;

	
	static {
	    
	    URL = "jdbc:mysql://127.0.0.1:3306/rpginventario";
	    USUARIO = "root";
	    SENHA = "";
	}

	
	private ConexaoBd() {
	}
	
	public static Connection getConexao() throws SQLException{
	   
	    if (conexao == null) {
		
		try {
		    System.out.println(">> Nova conexão estabelecida com o banco de dados");
		    conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException ex) {
		    System.out.println("A conexao falhou!!!");
		    Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);

		}
	    }

	    return conexao;
	}
}
