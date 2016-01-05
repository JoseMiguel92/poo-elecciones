package elecciones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class Eleccion implements Serializable {
//Atributos
    protected String nombre;
    protected double participacion;
    protected int escaños;
    protected TablaVotos resultadosTotalVotos;
    protected TablaEscaños resultadosTotalEscaños;
    protected String apodo;
    private ArrayList<EleccionEnCircunscripcion> eleccionesEnCircunscripcion;
    


    
//Contructores
    public Eleccion(String nombre) {
        this.nombre = nombre;
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
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String nombrePP = eleccionesEnCircunscripcion.get(i).getListasPartidos().get(j).getFormacionPolitica().getNombre();
            }
            
        }
        
    }
    public TablaEscaños getResultadosTotalEscaños() {
        return resultadosTotalEscaños;
    }
    public void setResultadosTotalEscaños(TablaEscaños resultadosTotalEscaños) {
        this.resultadosTotalEscaños = resultadosTotalEscaños;
    }
    
    
    
//Metodos Publicos
    public void realizarEleccion(){
        for(EleccionEnCircunscripcion circunscripcion : eleccionesEnCircunscripcion){
            circunscripcion.calcularResultados();
            circunscripcion.calcularListas();
        }
    }
    
    public void imprimirTablaGlobalVotos(){
    
    };
    public void imprimirTablaGlobalescaños(){
    
    };
    public void imprimirListaElectos(){
    
    };
    public void imprimirMayorias(){
    
    };
//Metodos Privados

}
