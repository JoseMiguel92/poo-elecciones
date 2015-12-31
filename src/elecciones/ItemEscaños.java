package elecciones;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class ItemEscaños {
//Atributos
    protected FormacionPolitica formacion;
    protected int numeroEscaños;
//Contructores
    public ItemEscaños(FormacionPolitica formacion, int numeroEscaños) {
        this.formacion = formacion;
        this.numeroEscaños = numeroEscaños;
    }
    
//GETs y SETs
    public FormacionPolitica getFormacion() {
        return formacion;
    }
    public void setFormacion(FormacionPolitica formacion) {
        this.formacion = formacion;
    }
    public int getNumeroEscaños() {
        return numeroEscaños;
    }
    public void setNumeroEscaños(int numeroEscaños) {
        this.numeroEscaños = numeroEscaños;
    }
    
//Metodos Publicos

//Metodos Privados




}
