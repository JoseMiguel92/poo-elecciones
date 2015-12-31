package elecciones;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */
public class ItemVotos {
//Atributos
    protected FormacionPolitica formacion;
    protected int numeroVotos;
//Contructores
    public ItemVotos(FormacionPolitica formacion, int numeroVotos) {
        this.formacion = formacion;
        this.numeroVotos = numeroVotos;
    }
    
//GETs y SETs
    public FormacionPolitica getFormacion() {
        return formacion;
    }
    public void setFormacion(FormacionPolitica formacion) {
        this.formacion = formacion;
    }
    public int getNumeroVotos() {
        return numeroVotos;
    }
    public void setNumeroVotos(int numeroVotos) {
        this.numeroVotos = numeroVotos;
    }
    
//Metodos Publicos

//Metodos Privados

}
