package elecciones;
/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Eleccion {
//Atributos
    protected String nombre;
    protected double participacion;
    protected int escaños;
    protected TablaVotos resultadosTotalVotos;
    protected TablaEscaños resultadosTotalEscaños;
    protected String apodo;
    
//Contructores
    public Eleccion(String nombre, double participacion, int escaños) {
        this.nombre = nombre;
        this.participacion = participacion;
        this.escaños = escaños;
    }
    
//GETs y SETs
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getParticipacion() {
        return participacion;
    }
    public void setParticipacion(double participacion) {
        this.participacion = participacion;
    }
    public int getEscaños() {
        return escaños;
    }
    public void setEscaños(int escaños) {
        this.escaños = escaños;
    }
    public TablaVotos getResultadosTotalVotos() {
        return resultadosTotalVotos;
    }
    public void setResultadosTotalVotos(TablaVotos resultadosTotalVotos) {
        this.resultadosTotalVotos = resultadosTotalVotos;
    }
    public TablaEscaños getResultadosTotalEscaños() {
        return resultadosTotalEscaños;
    }
    public void setResultadosTotalEscaños(TablaEscaños resultadosTotalEscaños) {
        this.resultadosTotalEscaños = resultadosTotalEscaños;
    }
    
//Metodos Publicos
    public void imprimirTablaGlobalVotos(){
    
    };
    public void imprimirTablaGlobalescaños(){
    
    };
    public void imprimirListaElectos(){
    
    };
    public void imprimirMayprias(){
    
    };
//Metodos Privados

}
