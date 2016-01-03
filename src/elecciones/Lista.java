package elecciones;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Lista {
//Atributos
    private String descripcion;
    private ArrayList<Militante> candidatos; // NO BORRAR
    private FormacionPolitica formacionPolitica;  // NO BORRAR
    private EleccionEnCircunscripcion eleccionEnCircunscripcion; // NO BORRAR

    
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
