
package br.edu.ifnmg.grnd.trabalhodepoo;

/**
 * Definição de métodos obrigatórios nas classes DAO.
 * autores: Gustavo, Lucas e Naum
 */
public interface IDao<E, K> {

    /**
     * Operação de salvamento de entidade no banco de dados
     *
     * @param e Entidade a ser salva
     * @return Chave primária da entidade salva
     */
    public K salvar(E e);
}
