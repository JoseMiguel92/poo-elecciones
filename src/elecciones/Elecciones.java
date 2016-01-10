package elecciones;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import vista.Igelec;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */
public class Elecciones implements Serializable{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */

    
    public static void main(String[] args) throws IOException {
        // Creamos la ventana principal de la aplicación
        Igelec app = new Igelec();
        // La hacemos visible
        app.setVisible(true);
           
    };
};
