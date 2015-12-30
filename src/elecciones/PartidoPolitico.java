package elecciones;
import java.util.ArrayList;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class PartidoPolitico extends FormacionPolitica {
    
    String[] pregMil = {"Pregunta Militante 1", "Pregunta Militante 2", "Pregunta Militante 3"};
    String[] pregSimp = {"Pregunta Simpatizante 1", "Pregunta Simpatizante 2", "Pregunta Simpatizante 3"};

//Contructores
    public PartidoPolitico(String nombre, String siglas, String logo) {
        super(nombre, siglas, logo);
        militantes = new Lista();
        votantes = new ArrayList<Votantes>();
    }

//Metodos Publicos
    public void cargarListas(){
    
    };

    @Override
    public String toString() {
        return "Nombre Partido: "+nombre+
                "Siglas Partido: "+siglas;
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

    public ArrayList<Votantes> getTodos_votantes() {
        return votantes;
    }

    public void setTodos_votantes(ArrayList<Votantes> todos_votantes) {
        this.votantes = todos_votantes;
    }
    
    
//Metodos Privados

}

