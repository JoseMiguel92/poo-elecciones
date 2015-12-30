package elecciones;
import java.util.ArrayList;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */
public class Coalicion extends FormacionPolitica{
    private ArrayList<PartidoPolitico> coalicion_partidos;

    
//Contructores
    public Coalicion(String nombre, String siglas, String logo) {
        super(nombre, siglas, logo);
    }
//GETs y SETs
    public ArrayList<PartidoPolitico> getCoalicion_partidos() {
        return coalicion_partidos;
    }

    public void setCoalicion_partidos(ArrayList<PartidoPolitico> coalicion_partidos) {
        this.coalicion_partidos = coalicion_partidos;
    }
    
//Metodos Publicos
    
    @Override
    public String toString(){
        
        // Lista de todos los partidos que forman la coalición
        StringBuilder partidos = new StringBuilder();
        for (PartidoPolitico p : coalicion_partidos){
            partidos.append(p.getNombre());
            partidos.append(";");
        }
        return "Nombre coalición: " +nombre+
                "\nSiglas: " +siglas+
                "\nFormada por los partidos: "+partidos;
    }
//Metodos Privados

}