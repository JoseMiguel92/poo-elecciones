package elecciones;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */
public class Coalicion extends FormacionPolitica implements Serializable{
    private ArrayList<PartidoPolitico> partidosCoalicion;

    
//Contructores
    public Coalicion(String nombre, String siglas, String logo){
        super(nombre,siglas,logo);
    }
    
    public Coalicion(String nombre, String siglas, String logo, ArrayList<PartidoPolitico> partidos){
        super(nombre,siglas,logo);
        this.partidosCoalicion = partidos;
        
        // ¿Cuantos partidos formaran la coalicion?
        militantes = new ArrayList<Militante>();
        
        int numPartidos = partidos.size();
        for (PartidoPolitico partido : partidos){
            int nMilis = partido.getMilitantes().size();
            List<Militante> milis = partido.getMilitantes().subList(0, nMilis*(1/numPartidos));
            
            militantes.addAll(milis);
        }
        
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
    public Lista elaborarListas(int escaños){
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
