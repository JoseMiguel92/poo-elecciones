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
    private ArrayList<Militante> diputados; // NO BORRAR
    private FormacionPolitica formacionPolitica;  // NO BORRAR
    private EleccionEnCircunscripcion circunscripcionPertenece; // NO BORRAR

    public ArrayList<Militante> getDiputados() {
        return diputados;
    }

    public void setDiputados(ArrayList<Militante> diputados) {
        this.diputados = diputados;
    }

    public FormacionPolitica getFormacionPolitica() {
        return formacionPolitica;
    }

    public void setFormacionPolitica(FormacionPolitica formacionPolitica) {
        this.formacionPolitica = formacionPolitica;
    }

    public EleccionEnCircunscripcion getCircunscripcionPertenece() {
        return circunscripcionPertenece;
    }

    public void setCircunscripcionPertenece(EleccionEnCircunscripcion eleccionEnCircunscripcion) {
        this.circunscripcionPertenece = eleccionEnCircunscripcion;
    }

    
//Contructores
    //Crear lista vacia (evitamos NULLPOINTEREXCEPTION)
    public Lista(){
        this.diputados = new ArrayList<Militante>();
    }
    // Crear lista a partir de ArrayList
    public Lista(ArrayList<Militante> lista){
        this.diputados = lista;
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
        return diputados;
    }
//Metodos Publicos
    public void add(Militante mil) {
        this.diputados.add(mil);
    }
    
//Metodos Privados

    @Override
    public String toString() {
        return formacionPolitica.getNombre()+ ": "+ diputados + ',';
    }
}
