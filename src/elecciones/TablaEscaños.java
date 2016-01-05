package elecciones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class TablaEscaños implements Serializable{
//Atributos
    protected ArrayList<ItemEscaños> tablaEscaños;

    public TablaEscaños(ArrayList<ItemEscaños> tabla_escaños) {
        this.tablaEscaños = tabla_escaños;
    }
    
    public ArrayList<ItemEscaños> getTablaEscaños() {
        return tablaEscaños;
    }

    public void setTabla_escaños(ArrayList<ItemEscaños> tabla_escaños) {
        this.tablaEscaños = tabla_escaños;
    }

    @Override
    public String toString() {
        return "Resultados: /n" + tablaEscaños + '.';
    }
    
    

}

