package elecciones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @autor Raul Martin
 * @autor Jose Miguel Garcia
 * @autor Daniel Oliver
 */

public class EleccionEnCircunscripcion implements Serializable{
//Atributos
    protected String nombre;
    protected int poblacion;
    protected int escaños;
    protected double participaccion;
    protected TablaVotos resultadoVotos;
    protected TablaEscaños resultadoEscaños;
    private ArrayList<Lista> listasPartidos;
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
    public void setEscaños(int poblacion) {
        if (poblacion<25){
            escaños=1;
        }else if(poblacion<101){
            escaños=2;
        }else if(poblacion<201){
            escaños=3;
        }else if (poblacion<301){
            escaños=4;
        }else{
            escaños=(int) (4+Math.ceil((poblacion-300)/300));
            if((escaños%2)==0){
                escaños++;
            }
        }
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
        for (int i = 0; i < listasPartidos.size(); i++) {
            FormacionPolitica formacion = listasPartidos.get(i).getFormacionPolitica();
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
        for (int i = 0; i < listasPartidos.size(); i++) {
            FormacionPolitica formacion = listasPartidos.get(i).getFormacionPolitica();
            ItemVotos a1;
            a1 = new ItemVotos(formacion,totalVotos);
            totalVotos-=numVotos;
            resultados.getTabla_votos().add(a1);   
        }
            this.votosBlanco=totalVotos;
        return resultados;
    };

    public TablaEscaños calcularResultados(TablaVotos votos){
           //Coger this.resultadoVotos
            this.setEscaños(poblacion);
            int escañosTotales = this.getEscaños();
            simularResultados();
            aplicarLey(votos, escañosTotales);
        return this.resultadoEscaños;
    };
    public void aplicarLey(TablaVotos votos, int escañosTotales){
        double [][] TablaAux = null;
        TablaVotos votos_copia = new TablaVotos(votos.getTabla_votos());
        for (int i = 0; i < votos_copia.getTabla_votos().size(); i++) {
            for (int j = 0; j < escañosTotales; j++) {
                TablaAux[i][j]=votos_copia.getTabla_votos().get(i).getNumeroVotos()/j;
            }
        }
        
        for (int j = 0; j < escañosTotales; j++) {
            int escañosNuevos = this.resultadoEscaños.getTabla_votos().get(Dhondt.getMaximo(TablaAux, escañosTotales, votos_copia.getTabla_votos().size())).getNumeroEscaños()+1;
            this.resultadoEscaños.getTabla_votos().get(Dhondt.getMaximo(TablaAux, escañosTotales, votos_copia.getTabla_votos().size())).setNumeroEscaños(escañosNuevos);
            }
        
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