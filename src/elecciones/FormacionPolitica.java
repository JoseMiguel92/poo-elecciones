package elecciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public abstract class FormacionPolitica implements Serializable{
//Atributos
    protected String nombre;
    protected String siglas;
    protected String logo;
    protected ArrayList<Militante> militantes; 
    //protected ArrayList<Votantes> votantes; // Segun el UML los votantes estan unidos con partido politico
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
    public ArrayList<Militante> getMilitantes(){
        return this.militantes;
    }
    public void setMilitantes(ArrayList<Militante> milis){
        this.militantes=milis;
    }
    /*
    public ArrayList<Votantes> getVotantes(){
        return this.votantes;
    }
    public void setVotantes(ArrayList<Votantes> vots){
        this.votantes=vots;
    }*/
//Metodos Publicos
    public Lista elaborarListas(int escaños){
        Lista lista = null;
        List<Militante> diputados = militantes.subList(0, escaños);
        
        lista.setDiputados(diputados);
        return lista;
    };

    @Override
    public String toString(){
        return "Nombre formación: " +nombre+
                "\nSiglas: " +siglas;
    }
    
//Metodos Privados

}
