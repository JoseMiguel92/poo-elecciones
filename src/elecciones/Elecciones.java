package elecciones;

import java.io.IOException;
import java.io.Serializable;
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
        // No tengo ni idea lo que significa Igelec
        Igelec app = new Igelec();
        // Lanzamos
        app.setVisible(true);
           
    };
};
