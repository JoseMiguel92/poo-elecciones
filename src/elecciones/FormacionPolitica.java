package elecciones;

import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class FormacionPolitica {
//Atributos
    protected String nombre;
    protected String siglas;
    protected String logo;
//Contructores
    public FormacionPolitica(String nombre, String siglas, String logo) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.logo = logo;
    }
    
//GETs y SETs
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSiglas() {
        return siglas;
    }
    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
//Metodos Publicos
  //public ArrayList elaborarListas(ArrayList m1, int escaños){
    public ArrayList elaborarListas(){
            
        return new ArrayList();
    };
    
    @Override
    public String toString(){
        return "Nombre formación: " +nombre+
                "\nSiglas: " +siglas;
    }
    
//Metodos Privados

}
