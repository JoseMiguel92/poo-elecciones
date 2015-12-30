package elecciones;
import java.util.ArrayList;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class PartidoPolitico extends FormacionPolitica {
    
    private ArrayList<Militante> militantes; 
    private ArrayList<Votantes> todos_votantes;

//Contructores
    public PartidoPolitico(String nombre, String siglas, String logo) {
        super(nombre, siglas, logo);
        militantes = new ArrayList<Militante>();
        todos_votantes = new ArrayList<Votantes>();
    }

//Metodos Publicos
    public void cargarListas(){
    
    };

    @Override
    public String toString() {
        return "PartidoPolitico{" + todos_votantes + '}';
    }

    @Override
    public ArrayList elaborarListas() {
        return super.elaborarListas(); //To change body of generated methods, choose Tools | Templates.
    }

    public void lanzarEncuestas(String encuestaMilitantes, String encuestaSimpatizantes){
        for (Votantes votante : todos_votantes) {
            if(votante instanceof Militante){
                votante.hacerEncuesta(encuestaMilitantes);
            } else if(votante instanceof Simpatizante){
                votante.hacerEncuesta(encuestaSimpatizantes);
            }
        }
    };

    public ArrayList<Votantes> getTodos_votantes() {
        return todos_votantes;
    }

    public void setTodos_votantes(ArrayList<Votantes> todos_votantes) {
        this.todos_votantes = todos_votantes;
    }
    
    
//Metodos Privados

    public ArrayList<Militante> getMilitantes() {
        return militantes;
    }

    public void setMilitantes(ArrayList<Militante> militantes) {
        this.militantes = militantes;
    }
}

