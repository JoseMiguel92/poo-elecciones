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
    private ArrayList<EleccionEnCircunscripcion> eleccionesEnCircunscripcion;

   

//Contructores
    public Eleccion(String nombre) {
        this.nombre = nombre;
    }
    
//GETs y SETs
     public ArrayList<EleccionEnCircunscripcion> getEleccionesEnCircunscripcion() {
        return eleccionesEnCircunscripcion;
    }

    public void setEleccionesEnCircunscripcion(ArrayList<EleccionEnCircunscripcion> eleccionesEnCircunscripcion) {
        this.eleccionesEnCircunscripcion = eleccionesEnCircunscripcion;
    }
    
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
    public void setResultadosTotalVotos() {
        for (EleccionEnCircunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<ItemVotos> x_tablaVotos = circuns.getResultadoVotos().getTabla_votos();
            for (ItemVotos vots_itemVotos : x_tablaVotos){
                FormacionPolitica partido = vots_itemVotos.getFormacion();
                int votos = vots_itemVotos.getNumeroVotos();
                int posicion = damePosicion_votos(partido);
                if (posicion == -1){
                    resultadosTotalVotos.getTabla_votos().add(vots_itemVotos);
                }else{
                    x_tablaVotos.get(posicion).setNumeroVotos(x_tablaVotos.get(posicion).getNumeroVotos()+votos);
                }
            }
        }
    }
    private int damePosicion_votos(FormacionPolitica partido){
        for (int i=0; i<resultadosTotalVotos.getTabla_votos().size(); i++ ){
            if(resultadosTotalVotos.getTabla_votos().get(i).getFormacion().equals(partido)){
                return i;
            }
        }
        return -1;
    }
    
        public void setResultadosTotalEscaños() {
        for (EleccionEnCircunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<ItemEscaños> x_tablaEscaños = circuns.getResultadoEscaños().getTablaEscaños();
            for (ItemEscaños escaños_itemEscaños : x_tablaEscaños){
                FormacionPolitica partido = escaños_itemEscaños.getFormacion();
                int escaños = escaños_itemEscaños.getNumeroEscaños();
                int posicion = damePosicion_escaños(partido);
                if (posicion == -1){
                    resultadosTotalEscaños.getTablaEscaños().add(escaños_itemEscaños);
                }else{
                    x_tablaEscaños.get(posicion).setNumeroEscaños(x_tablaEscaños.get(posicion).getNumeroEscaños()+escaños);
                }
            }
        }
    }
    private int damePosicion_escaños(FormacionPolitica partido){
        for (int i=0; i<resultadosTotalEscaños.getTablaEscaños().size(); i++ ){
            if(resultadosTotalEscaños.getTablaEscaños().get(i).getFormacion().equals(partido)){
                return i;
            }
        }
        return -1;
    }
    
    
    
//    private boolean noEsta(FormacionPolitica partido){
//        for (ItemVotos vots_aux: resultadosTotalVotos.getTabla_votos()){
//            if (partido.equals(vots_aux.getFormacion() ) ){
//               return false;
//            }
//        }
//        return true;
//    }
    public TablaEscaños getResultadosTotalEscaños() {
        return resultadosTotalEscaños;
    }
    public void setResultadosTotalEscaños(TablaEscaños resultadosTotalEscaños) {
        this.resultadosTotalEscaños = resultadosTotalEscaños;
    }
    
    
    
//Metodos Publicos
    public void realizarEleccion(){
        for(EleccionEnCircunscripcion circunscripcion : eleccionesEnCircunscripcion){
            circunscripcion.calcularResultados();// DEVUELVE LOS ESCAÑOS DE CADA PÀRTIDO POR CIRCUNSCRIPCION
            circunscripcion.calcularListas();
        }
    }
    
    public String imprimirTablaGlobalVotos(){
        return resultadosTotalVotos.toString();
    };
    public String imprimirTablaGlobalescaños(){
        return resultadosTotalEscaños.toString();
    };
    public String imprimirListaElectos(){
        
        return crearListaElectos().toString();
    };
    
    private ArrayList<Lista> crearListaElectos() {
        ArrayList<Lista> listaElectos = new ArrayList<>();
        for (EleccionEnCircunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<Lista> x_listasPartidos = circuns.getListasPartidos();
            for (Lista lista : x_listasPartidos){
                FormacionPolitica partido = lista.getFormacionPolitica();
                ArrayList<Militante> militantes = lista.getDiputados();
                int posicion = damePosicion_Electos(partido,listaElectos);
                if (posicion == -1){
                    listaElectos.add(lista);
                }else{
                    listaElectos.add(posicion, lista);
                }
            }
        }
        return listaElectos;
    }
    private int damePosicion_Electos(FormacionPolitica partido, ArrayList<Lista> listaElectos ){
        for (int i=0; i<listaElectos.size(); i++ ){
            if(listaElectos.get(i).getFormacionPolitica().equals(partido)){
                return i;
            }
        }
        return -1;
    }
    
    
    
    
    public void imprimirMayorias(){
    
    };
//Metodos Privados

}
