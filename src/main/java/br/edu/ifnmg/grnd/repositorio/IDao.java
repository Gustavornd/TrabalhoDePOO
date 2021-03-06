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

/**
 * Definição de métodos obrigatórios nas classes DAO. autores: Gustavo, Lucas e
 * Naum
 */
public interface IDao<E, K> {

    /**
     * Operação de salvamento de entidade no banco de dados
     *
     * @param e Entidade a ser salva
     * @return Chave primária da entidade salva
     */
    public K salvar(E e);

    public Boolean excluir(E o);
}
