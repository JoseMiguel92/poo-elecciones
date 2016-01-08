package elecciones;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class PartidoPolitico extends FormacionPolitica implements Serializable{
    
    private String[] pregMil = {
        "En su conjunto, ¿cómo calificaría Ud. la gestión que h a realizado el Gobierno del PP durante estos últimos cuatro años: muy buena, buena, regular, mala o muy mala?",
        "¿Cree que si hubiera estado el PSOE al frente del Gobierno lo habría hecho mejor, igual o peor?",
        "¿Cómo calificaría Ud. la actuación política que ha desarrollado el PSOE en la oposición en estos cuatro años: muy buena, buena, regular, mala o muy mala?"
    };
    private String[] pregSimp = {
        "¿diría Ud. que, en líneas generales, la política le interesa: mucho, bastante, poco o nada?",
        "En  general,  ¿con  qué  frecuencia  habla  Ud.  de  política  con  sus amigos/as, familiares o compañeros/as de trabajo...?",
        "Refiriéndonos  ahora  a  la situación  política general  de  España, ¿cómo la calificaría Ud.: muy buena, buena, regular, mala o muy mala?"
    };
    
    private ArrayList<Votantes> votantes = new ArrayList<>();
    private ArrayList<Militante> militantes = new ArrayList<>(); // utilizo nombre de militantes para mayor claridad

    public ArrayList<Votantes> getVotantes() {
        return votantes;
    }

    public void setVotantes(ArrayList<Votantes> votantes) {
        this.votantes = votantes;
    }
    
    public ArrayList<Militante> getMilitantes() {
        return militantes;
    }

    @Override
    public void setMilitantes(ArrayList<Militante> militantes) {
        this.militantes = militantes;
    }

//Contructores
    public PartidoPolitico(String nombre, String siglas, String logo) {
        super(nombre, siglas, logo);
        // comentado para pruebas candidatos = new Lista(); //Array con los militantes que iran en la lista.
        votantes = new ArrayList<>(); //Todos los votantes de este partido, militantes y simpatizantes, "censo".
        militantes = new ArrayList<> ();  // lista deMilitantes del partido
    }
    
    public PartidoPolitico(PartidoPolitico p){
        super(p.getNombre(),p.getSiglas(),p.getLogo());
    }
    
    


//Metodos Publicos    
    public void cargarListas(){
    
    };

    @Override
    public String toString() {
        return "PartidoPolitico{" + "militantes=" + militantes + '}';
    }

    public String[] getPregMil() {
        return pregMil;
    }

    public String[] getPregSimp() {
        return pregSimp;
    }
    
    





    public void lanzarEncuestas(){
        for (Votantes votante : votantes) {
            if(votante instanceof Militante){
                votante.enviarEncuesta(pregMil);
            } else if(votante instanceof Simpatizante){
                votante.enviarEncuesta(pregSimp);
            }
        }
    };
    
    public void addSimpatizante(Simpatizante simpa1){
        votantes.add(simpa1);
    }

}

