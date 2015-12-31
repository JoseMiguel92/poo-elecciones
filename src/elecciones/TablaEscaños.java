package elecciones;

import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class TablaEscaños {
//Atributos
    protected ArrayList<ItemEscaños> tabla_escaños;

    public TablaEscaños(ArrayList<ItemEscaños> tabla_escaños) {
        this.tabla_escaños = tabla_escaños;
    }
    
    public ArrayList<ItemEscaños> getTabla_votos() {
        return tabla_escaños;
    }

    public void setTabla_escaños(ArrayList<ItemEscaños> tabla_escaños) {
        this.tabla_escaños = tabla_escaños;
    }
    

}

