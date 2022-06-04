
package br.edu.ifnmg.grnd.trabalhodepoo;

/*
    Autor: Friedrich Naum
*/

public class Personagem {
    
    private Integer id;
    private String nome;
    private Double limPeso;
    private Double dinheiro;
    private Integer ca;
    private Inventario inventario;


   //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    public Personagem()
    {
        
    }
    public Personagem(Integer id, String nome, Double limPeso, Double dinheiro, Integer ca, Inventario inventario) {
        this.id = id;
        this.limPeso = limPeso;
        this.dinheiro = dinheiro;
        this.ca = ca;
        this.inventario = inventario;
        this.nome = nome;
    }
//</editor-fold>
    
    

    //<editor-fold defaultstate="collapsed" desc="Getterss And Settters">
    
    public Integer getId() {    
        return id;
    }
    
    public void setId(Integer id) {    
        this.id = id;
    }

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
    
    public void calcCA(){
        Armadura ja = new Armadura();
        if(ja.getEquipado()== true){
            this.ca += ja.getDefesa();
        }
        System.out.println(" CA Atual = " + this.ca);
    }
    
    public void calcPeso(){
        int peso = 0;
            for(int j =0; j<this.inventario.listaItens.size();j++)
            {
                      peso += this.inventario.listaItens.get(j).getPeso();
                      if(this.limPeso<peso)
                      {
                          System.out.println("Vocé está pesado!! Deslocamento e Velocidade do Personagem caiu Drásticamente");
                      }
                      if(this.limPeso == peso)
                      {
                          System.out.println("Seu peso está quase ultrapassando o limite de peso!!");
                      }
            }
            System.out.println("Peso Atual: "+ peso + "\nLimite do Peso: " + this.limPeso + "\nFalta " + (this.limPeso-peso)+ " para chegar ao limite");
        }
    
    public void calcMoney(){
            int money = 0;
            for(int i = 0; i< this.inventario.listaTrans.size();i++)
            {
                      money += this.inventario.listaTrans.get(i).getValor();                      
            }
            System.out.println("Gasto Atual: "+ money + "\nDinheiro Total: " + this.dinheiro + "\nDinheiro Total Agora " + (this.dinheiro - money));
    }
    
    @Override
    public String toString() {
        return "Personagem{" + "limPeso=" + limPeso + ", dinheiro=" + dinheiro + ", ca=" + ca + ", inventario=" + inventario + ", nome=" + nome + '}';
    }
}
