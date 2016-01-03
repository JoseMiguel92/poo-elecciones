package elecciones;

import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class EleccionEnCircunscripcion {
//Atributos
    protected String nombre;
    protected int poblacion;
    protected int escaños;
    protected double participaccion;
    protected TablaVotos resultadoVotos;
    protected TablaEscaños resultadoEscaños;
    private ArrayList<Lista> listas;
    private int votosBlanco;
    
//Contructores
    public EleccionEnCircunscripcion(String nombre, int poblacion, int escaños, double participaccion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.escaños = escaños;
        this.participaccion = participaccion;
    }
    
//GETs y SETs
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
    public int getEscaños() {
        return escaños;
    }
    public void setEscaños(int escaños) {
        this.escaños = escaños;
    }
    public double getParticipaccion() {
        return participaccion;
    }
    public void setParticipaccion(double participaccion) {
        this.participaccion = participaccion;
    }
    public TablaVotos getResultadoVotos() {
        return resultadoVotos;
    }
    public void setResultadoVotos(TablaVotos resultadoVotos) {
        this.resultadoVotos = resultadoVotos;
    }
    public TablaEscaños getResultadoEscaños() {
        return resultadoEscaños;
    }
    public void setResultadoEscaños(TablaEscaños resultadoEscaños) {
        this.resultadoEscaños = resultadoEscaños;
    }
    
//Metodos Publicos
    public TablaVotos simularResultados(){
        TablaVotos resultados = new TablaVotos();
        int totalVotos = (int) (this.getPoblacion()*Math.round(this.participaccion));
        for (int i = 0; i < listas.size(); i++) {
            FormacionPolitica formacion = listas.get(i).getFormacionPolitica();
            ItemVotos a1;
            int numVotos = (int)(Math.random() * totalVotos);
            a1 = new ItemVotos(formacion,totalVotos);
            totalVotos-=numVotos;
            resultados.getTabla_votos().add(a1);   
        }
            this.votosBlanco=totalVotos;
        return resultados;
    };
        public TablaVotos simularResultados(int numVotos){
            //Cuidado con tener numVotos mayor que totalVotos
        TablaVotos resultados = new TablaVotos();
        int totalVotos = (int) (this.getPoblacion()*Math.round(this.participaccion));
        for (int i = 0; i < listas.size(); i++) {
            FormacionPolitica formacion = listas.get(i).getFormacionPolitica();
            ItemVotos a1;
            a1 = new ItemVotos(formacion,totalVotos);
            totalVotos-=numVotos;
            resultados.getTabla_votos().add(a1);   
        }
            this.votosBlanco=totalVotos;
        return resultados;
    };

    public TablaEscaños calcularResultados(TablaVotos votos){
                
        return this.resultadoEscaños;
    };
    public void calcularListas(TablaEscaños escaños){
    
    };
    //OPCIONALES
    public void imprimirTablaVotos(){
    
    };
    public void imprimirTablaescaños(){
    
    };
    
//Metodos Privados

}