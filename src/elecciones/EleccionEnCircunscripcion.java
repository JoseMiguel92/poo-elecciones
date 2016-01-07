package elecciones;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    protected double participacion;
    protected TablaVotos resultadoVotos;
    protected TablaEscaños resultadoEscaños;
    private ArrayList<Lista> listasPartidos;
    private int votosBlanco;
    protected ArrayList<FormacionPolitica> formaciones;
    
//Contructores
    public EleccionEnCircunscripcion(String nombre, int poblacion, double participacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.escaños = Escaños(poblacion);
        this.participacion = participacion;
    }
    
    public ArrayList<Lista> getListasPartidos() {
        return listasPartidos;
    }

//GETs y SETs
    public void setFormaciones(ArrayList<FormacionPolitica> formaciones){
        this.formaciones = formaciones;
    }
    public ArrayList<FormacionPolitica> getFormaciones(){
        return this.formaciones;
    }
    public void setListasPartidos(ArrayList<Lista> listasPartidos) {    
        this.listasPartidos = listasPartidos;
    }

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
        if (poblacion<251){
            escaños=5;
        } else if (poblacion<1001){
            escaños=7;
        } else if (poblacion<2001){
            escaños=9;
        } else if (poblacion<5001){
            escaños=11;
        } else if (poblacion<10001){
            escaños=13;
        } else if (poblacion<20001){
            escaños=17;
        } else if (poblacion<50001){
            escaños=21;
        } else if (poblacion<100001){
            escaños=25;
        } else {
            escaños=(int) (25+Math.ceil((poblacion-100000)/100000));
            if((escaños%2)==0){
                escaños++;
            }
        }
    }
    public int Escaños(int poblacion){
        if (poblacion<25){
            return 1;
        }else if(poblacion<101){
             return 2;
        }else if(poblacion<201){
            return 3;
        }else if (poblacion<301){
            return 4;
        }else{
            int esc = (int) (4+Math.ceil((poblacion-300)/300));
            if((esc%2)==0){
                return esc+1;
            } else return esc;
        }
    }
    public double getParticipacion() {
        return participacion;
    }
    public void setParticipacion(double participaccion) {
        this.participacion = participaccion;
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
//    public void simularResultados(){
//        int totalVotos = (int) Math.round(this.getPoblacion()*this.participacion);
//        for (int i = 0; i < listasPartidos.size(); i++) {
//            FormacionPolitica formacion = listasPartidos.get(i).getFormacionPolitica();
//            int numVotos = (int)(Math.random() * totalVotos);
//            ItemVotos a1 = new ItemVotos(formacion,numVotos);
//            totalVotos-=numVotos;
//            this.resultadoVotos.getTabla_votos().add(a1);   
//        }
//            this.votosBlanco=totalVotos;
//    };
    public void simularResultados() throws IllegalArgumentException{       
        int totalVotos = (int) Math.round((this.getPoblacion()*this.participacion));
        for (int i = 0; i < listasPartidos.size(); i++) {
            int numVotos=pedirVotos();
            if(numVotos==-1){
                numVotos = (int)(Math.random() * totalVotos);
             }
            // Si nVotos mayor a total votos tiramos excepcion
            if(numVotos>totalVotos) throw new IllegalArgumentException();
            FormacionPolitica formacion = listasPartidos.get(i).getFormacionPolitica();
            ItemVotos votospartido = new ItemVotos(formacion,numVotos);
            totalVotos-=numVotos;
            this.resultadoVotos.getTabla_votos().add(votospartido);   
        }
        this.votosBlanco=totalVotos;
    };

    public void calcularResultados(){
           //Coger this.resultadoVotos
            int escañosTotales = this.getEscaños();
            simularResultados();//DEVUELVE resultadoVotos
            
            aplicarLey(resultadoVotos, escañosTotales);
    };

        
    public void calcularListas(){
        for (int i = 0; i < resultadoEscaños.getTablaEscaños().size(); i++) {
            FormacionPolitica partido = resultadoEscaños.getTablaEscaños().get(i).getFormacion();
            int escaños = resultadoEscaños.getTablaEscaños().get(i).getNumeroEscaños();
            Lista listaPartido = partido.elaborarListas(escaños);
            listaPartido.setCircunscripcionPertenece(this);
            listasPartidos.add(i, listaPartido);     
        }
    };
    //OPCIONALES
    public void imprimirTablaVotos(){
    
    };
    public void imprimirTablaescaños(){
    
    };
    
//Metodos Privados
    private void aplicarLey(TablaVotos votos, int escañosTotales){
        double [][] TablaAux = null;
        TablaVotos votos_copia = new TablaVotos(votos.getTabla_votos());
        for (int i = 0; i < votos_copia.getTabla_votos().size(); i++) {
            for (int j = 0; j < escañosTotales; j++) {
                TablaAux[i][j]=votos_copia.getTabla_votos().get(i).getNumeroVotos()/j;
            }
        }
        
        for (int j = 0; j < escañosTotales; j++) {
            int escañosNuevos = this.resultadoEscaños.getTablaEscaños().get(Dhondt.getMaximo(TablaAux, escañosTotales, votos_copia.getTabla_votos().size())).getNumeroEscaños()+1;
            this.resultadoEscaños.getTablaEscaños().get(Dhondt.getMaximo(TablaAux, escañosTotales, votos_copia.getTabla_votos().size())).setNumeroEscaños(escañosNuevos);
            }
        
    };
    
    private int pedirVotos(){
        int numVotos=0;
        if (true){//ELEGIR O NO POR INTERFAZ
            //numVotos=LO QUE DIGA LA INTERFAZ
        }else numVotos=-1;//SI DA QUE NO SE INICIA A -1
        return numVotos;
    }
}
