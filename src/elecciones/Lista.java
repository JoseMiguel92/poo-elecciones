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
    private String descripcion = "Descripción por defecto";
    private ArrayList<Militante> diputados = new ArrayList<>(); // NO BORRAR
    private FormacionPolitica formacionPolitica;  // NO BORRAR
    private Circunscripcion circunscripcionPertenece; // NO BORRAR

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

    public Circunscripcion getCircunscripcionPertenece() {
        return circunscripcionPertenece;
    }

    public void setCircunscripcionPertenece(Circunscripcion eleccionEnCircunscripcion) {
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
    // Crear la lista pasando todo
    public Lista(ArrayList<Militante> lista, FormacionPolitica f,Circunscripcion e, String d) {
        // Comprobamos que la lista sea tan grande como los escaños
        this.circunscripcionPertenece = e;
        this.diputados = lista;
        
        this.formacionPolitica = f;
        this.descripcion = d;
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
        return formacionPolitica.getNombre()+ ": "+ diputados + ','+ circunscripcionPertenece.getNombre() ;
    }
}
