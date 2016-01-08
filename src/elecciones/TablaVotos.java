package elecciones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class TablaVotos implements Serializable{
//Atributos
    protected ArrayList<ItemVotos> tabla_votos;

    @Override
    public String toString() {
        return "Resultados: /n" + tabla_votos + '.';
    }

    public TablaVotos(ArrayList<ItemVotos> tabla_votos) {
        this.tabla_votos = new ArrayList<>();
        this.tabla_votos = tabla_votos;
    }
    
    public TablaVotos(){
        this.tabla_votos = new ArrayList<>();
    }
    
    public ArrayList<ItemVotos> getTabla_votos() {
        return tabla_votos;
    }

    public void setTabla_votos(ArrayList<ItemVotos> tabla_votos) {
        this.tabla_votos = tabla_votos;
        
    }

}
