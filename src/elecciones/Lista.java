package elecciones;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Lista implements Serializable{
//Atributos
    private String descripcion;
    private ArrayList<Militante> candidatos; // NO BORRAR
    private FormacionPolitica formacionPolitica;  // NO BORRAR
    private EleccionEnCircunscripcion eleccionEnCircunscripcion; // NO BORRAR

    public ArrayList<Militante> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ArrayList<Militante> candidatos) {
        this.candidatos = candidatos;
    }

    public FormacionPolitica getFormacionPolitica() {
        return formacionPolitica;
    }

    public void setFormacionPolitica(FormacionPolitica formacionPolitica) {
        this.formacionPolitica = formacionPolitica;
    }

    public EleccionEnCircunscripcion getEleccionEnCircunscripcion() {
        return eleccionEnCircunscripcion;
    }

    public void setEleccionEnCircunscripcion(EleccionEnCircunscripcion eleccionEnCircunscripcion) {
        this.eleccionEnCircunscripcion = eleccionEnCircunscripcion;
    }

    
//Contructores
    //Crear lista vacia (evitamos NULLPOINTEREXCEPTION)
    public Lista(){
        this.candidatos = new ArrayList<Militante>();
    }
    // Crear lista a partir de ArrayList
    public Lista(ArrayList<Militante> lista){
        this.candidatos = lista;
    }
    // Crear lista a partir de un fichero de texto dado su nombre.
    public Lista(String nombreArchivo) throws IOException{
        
        this(Auxiliar.CargarLista(nombreArchivo));
    }
//GETs y SETs
    public void setDescripcion (String d1){
        this.descripcion = d1;
    }
    
    public ArrayList<Militante> getLista_militantes() {
        return candidatos;
    }
//Metodos Publicos
    public void add(Militante mil) {
        this.candidatos.add(mil);
    }
//Metodos Privados
}
