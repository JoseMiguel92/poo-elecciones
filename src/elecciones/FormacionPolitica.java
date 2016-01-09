package elecciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    protected ArrayList<Militante> militantes = new ArrayList<>(); 
    //protected ArrayList<Votantes> votantes; // Segun el UML los votantes estan unidos con partido politico.
    private ArrayList<String> nombresPartidos = new ArrayList<>();
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
    
    public ArrayList<String> getNombresPartidos() {
        return nombresPartidos;
    }

    public void setNombresPartidos(ArrayList<String> nombresPartidos) {
        this.nombresPartidos = nombresPartidos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormacionPolitica other = (FormacionPolitica) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
//Metodos Publicos
    public Lista elaborarListas(int escaños){
        Lista lista = new Lista();

        ArrayList<Militante> diputados = new ArrayList<>(militantes.subList(0, escaños-1));
//        ArrayList<Militante> diputados = new ArrayList<>();
//        diputados.addAll(dipu);

        lista.setDiputados(diputados);
        lista.setFormacionPolitica(this);        
        return lista;
    };

    @Override
    public String toString(){
        return "Nombre formación: " +nombre+
                "\nSiglas: " +siglas;
    }
    
//Metodos Privados

}
