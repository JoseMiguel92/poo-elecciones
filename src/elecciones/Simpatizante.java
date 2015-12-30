package elecciones;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Simpatizante extends Votantes{
    String[] pregSimp = {"Pregunta Simpatizante 1", "Pregunta Simpatizante 2", "Pregunta Simpatizante 3"};
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
    //Metodos Privados

}