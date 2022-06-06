
package br.edu.ifnmg.grnd.entidade;

/**
 * Aspectos comuns a todas as entidades gerenciadas pelo sistema.
 */
public abstract class Entidade {

    // Representação da chave primária padrão para a entidade.
    private Long id;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    protected Entidade() {
    }

    protected Entidade(Long id) {
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //</editor-fold>

}
