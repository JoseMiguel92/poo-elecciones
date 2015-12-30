package elecciones;
import java.util.ArrayList;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */
public class Coalicion extends FormacionPolitica{
    private ArrayList<PartidoPolitico> partidosCoalicion;

    
//Contructores
    public Coalicion(String nombre, String siglas, String logo) {
        super(nombre, siglas, logo);
    }
//GETs y SETs
    public ArrayList<PartidoPolitico> getCoalicion_partidos() {
        return partidosCoalicion;
    }
    public void setCoalicion_partidos(ArrayList<PartidoPolitico> coalicion_partidos) {
        this.partidosCoalicion = coalicion_partidos;
    }
    
//Metodos Publicos
    @Override
    public Lista elaborarListas(Eleccion eleccion){
        Lista lista = null;
        return lista;
    }
    
    @Override
    public String toString(){
        
        // Lista de todos los partidos que forman la coalición
        StringBuilder partidos = new StringBuilder();
        for (PartidoPolitico p : partidosCoalicion){
            partidos.append(p.getNombre());
            partidos.append(";");
        }
        return "Nombre coalición: " +nombre+
                "\nSiglas: " +siglas+
                "\nFormada por los partidos: "+partidos;
    }
//Metodos Privados

}