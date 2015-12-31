package elecciones;

import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class TablaVotos {
//Atributos
    protected ArrayList<ItemVotos> tabla_votos;

    public TablaVotos(ArrayList<ItemVotos> tabla_votos) {
        this.tabla_votos = tabla_votos;
    }
    
    public ArrayList<ItemVotos> getTabla_votos() {
        return tabla_votos;
    }

    public void setTabla_votos(ArrayList<ItemVotos> tabla_votos) {
        this.tabla_votos = tabla_votos;
        
    }
}
