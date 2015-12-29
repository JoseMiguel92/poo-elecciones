package elecciones;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Militante extends Votantes{
//Atributos
    protected double cuota;
    protected String carnet;
    String[] pregMil = {"Pregunta Militante 1", "Pregunta Militante 2", "Pregunta Militante 3"};
//Contructores
    public Militante(double cuota, String carnet, String nombreApellidos, int edad, String profesion, char genero, String siglasPartido) {
        super(nombreApellidos, edad, profesion, genero, siglasPartido);
        this.cuota = cuota;
        this.carnet = carnet;
    }
    public Militante(String nombreApellidos){
        super(nombreApellidos);
    }
//GETs y SETs
    public double getCuota() {
        return cuota;
    }
    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
    public String getCarnet() {
        return carnet;
    }
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }
//Metodos Publicos
    @Override
    public void enviarEncuesta() {
        encuesta=pregMil.clone(); 
    }
   
//Metodos Privados

    @Override
    public String toString() {
        return "Militante{" + nombreApellidos + ", cuota= " + cuota + "€" +", carnet= " + carnet + '}';
    }



}
