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
    public void enviarEncuesta(String[] enc1){
        this.setEncuesta(enc1);
    }
   
//Metodos Privados

    @Override
    public String toString() {
        return super.toString()+
                "\nNumero Carnet: "+this.carnet+
                "\nCuota: "+this.cuota;
    }



}
