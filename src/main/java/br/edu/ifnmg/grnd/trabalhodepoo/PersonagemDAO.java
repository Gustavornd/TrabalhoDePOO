package br.edu.ifnmg.grnd.trabalhodepoo;

/*
Autor: Friedrich Naum
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonagemDAO extends Dao<Personagem, Long> {

    /*
    CREATE TABLE personagem (
        `id` int NOT NULL AUTO_INCREMENT,
        `nome` varchar(200),
        `limPeso` float,
        `dinheiro` float,
        `ca` int,
        `inventario` int,
        PRIMARY KEY (`id`),
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1
-- */
    @Override
    public String obterSentencaInsert() {
        return "insert into personagem (nome, limPeso, dinheiro, ca, inventario) values (?, ?, ?, ?, ?);";
    }

    @Override
    public String obterSentencaUpdate() {
        return "update personagem set nome = ?, limPeso = ?, dinheiro = ?, ca = ?, inventario = ? where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, nome, limPeso, dinheiro, ca, inventario from personagem where id = ?;";
    }

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, nome, limPeso, dinheiro, ca, inventario from personagem where excluido = false;";
    }

    /**
     * Substitui elementos variáveis na SQL preparada a partir do objeto de
     * referência recebido
     *
     * @param pstmt Consulta preparada com valores ausentes
     * @param e Objeto com dados relevantes para a consulta
     */
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Personagem e) {
        try {
            pstmt.setString(1, e.getNome());
            pstmt.setDouble(2, e.getLimPeso());
            pstmt.setDouble(3, e.getDinheiro());
            pstmt.setInt(4, e.getCa());
            pstmt.setLong(5, new InventarioDAO().salvar(e.getInventario()));

            if (e.getId() != null && e.getId() != 0) {
                pstmt.setLong(6, e.getId());
            }

        } catch (Exception ex) {
            System.out.println("Exceptoin: " + ex);
        }
    }

    /**
     * Extrai um objeto Personagem do resultado gerado pela consulta
     *
     * @param resultSet Registro recuperado do banco de dados
     * @return Personagem equivalente ao registro recebido
     */
    @Override
    public Personagem extrairObjeto(ResultSet resultSet) {
        Personagem pr = new Personagem();

        try {
            pr.setId(resultSet.getLong("id"));
            pr.setNome(resultSet.getString("nome"));
            pr.setLimPeso(resultSet.getDouble("limPeso"));
            pr.setDinheiro(resultSet.getDouble("dinheiro"));
            pr.setCa(resultSet.getInt("ca"));
            Inventario inv = new InventarioDAO().localizarPorId(resultSet.getLong("inventario"));
            pr.setInventario(inv);

        } catch (SQLException ex) {
            Logger.getLogger(PersonagemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pr;
    }

}
