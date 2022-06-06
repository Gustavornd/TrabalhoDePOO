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

/*
 * Entidade que representa um Personagem.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
public class Personagem extends Entidade {

    private String nome;
    private Double limPeso;
    private Double dinheiro;
    private Integer ca;
    private Inventario inventario;

    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    public Personagem() {

    }

    public Personagem(String nome, Double limPeso, Double dinheiro, Integer ca, Inventario inventario) {
        this.nome = nome;
        this.limPeso = limPeso;
        this.dinheiro = dinheiro;
        this.ca = ca;
        this.inventario = inventario;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getterss And Settters">
    public Double getLimPeso() {
        return limPeso;
    }

    public void setLimPeso(Double limPeso) {
        this.limPeso = limPeso;
    }

    public Double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Integer getCa() {
        return ca;
    }

    public void setCa(Integer ca) {
        this.ca = ca;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//</editor-fold>
    // Realiza o calculo do coeficiente de armadura atual
    public void calcCA() {
        Armadura ja = new Armadura();
        if (ja.getEquipado() == true) {
            this.ca += ja.getDefesa();
        }
        System.out.println(" CA Atual = " + this.ca);
    }

    // Realiza o calculo do Peso, do limite do peso e o quanto falta para atingir esse limite.
    // Tambem verifica se o personagem ja ultrapassou ou esta perto de ultrapassar esse limite.
    public void calcPeso() {
        int peso = 0;
        for (int j = 0; j < this.inventario.listaItens.size(); j++) {
            peso += this.inventario.listaItens.get(j).getPeso();
            if (this.limPeso < peso) {
                System.out.println("Vocé está pesado!! Deslocamento e Velocidade do Personagem caiu Drásticamente");
            }
            if (this.limPeso == peso) {
                System.out.println("Seu peso está quase ultrapassando o limite de peso!!");
            }
        }
        System.out.println("Peso Atual: " + peso + "\nLimite do Peso: " + this.limPeso + "\nFalta " + (this.limPeso - peso) + " para chegar ao limite");
    }

    //Realiza o calculo do dinheiro total, do gasto e a quantidade restante apos o gasto.
    public void calcMoney() {
        int money = 0;
        for (int i = 0; i < this.inventario.listaTrans.size(); i++) {
            money += this.inventario.listaTrans.get(i).getValor();
        }
        System.out.println("Gasto Atual: " + money + "\nDinheiro Total: " + this.dinheiro + "\nDinheiro Total Agora " + (this.dinheiro - money));
    }

    @Override
    public String toString() {
        return "Personagem{" + "limPeso=" + limPeso + ", dinheiro=" + dinheiro + ", ca=" + ca + ", inventario=" + inventario + ", nome=" + nome + '}';
    }
}
