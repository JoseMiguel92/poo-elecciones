package elecciones;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Simpatizante extends Votantes{
    
//Contructores
    public Simpatizante(String nombreApellido, int edad, String profesion, char genero, String siglasPartido) {
        super(nombreApellido, edad, profesion, genero, siglasPartido);
    }
    public Simpatizante(String nombreApellido){
        super(nombreApellido);
    }
//Metodos Publicos
    @Override
    public String toString(){
        return super.toString();
    }
    
    public void enviarEncuesta(String[] enc1){
        this.setEncuesta(enc1);
    }
    //Metodos Privados

}