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
        candidatos = new Lista(); //Array con los militantes que iran en la lista.
        votantes = new ArrayList<Votantes>(); //Todos los votantes de este partido, militantes y simpatizantes, "censo".
    }

//Metodos Publicos
    @Override
    public Lista elaborarListas(Eleccion eleccion){
        Lista lista = null;
        return lista;
    }
    
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
    
    public void addSimpatizante(Simpatizante simpa1){
        votantes.add(simpa1);
    }

}

