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
    protected String nombre = "Sin nombre";
    protected double participacion;
    protected int escaños;
    protected ArrayList<ItemVotos> resultadosTotalVotos = new ArrayList<>();
    protected ArrayList<ItemEscaños> resultadosTotalEscaños = new ArrayList<>();
    private ArrayList<Circunscripcion> eleccionesEnCircunscripcion = new ArrayList<>();

//Contructores
    public Eleccion(String nombre) {
        this.nombre = nombre;
    }
    
//GETs y SETs
     public ArrayList<Circunscripcion> getEleccionesEnCircunscripcion() {
        return eleccionesEnCircunscripcion;
    }

    public void setEleccionesEnCircunscripcion(ArrayList<Circunscripcion> eleccionesEnCircunscripcion) {
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
    public ArrayList<ItemVotos> getResultadosTotalVotos() {
        return resultadosTotalVotos;
    }
    public void setResultadosTotalVotos() {
        for (Circunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<ItemVotos> x_tablaVotos = circuns.getResultadoVotos();
            for (ItemVotos vots_itemVotos : x_tablaVotos){
                FormacionPolitica partido = vots_itemVotos.getFormacion();
                int votos = vots_itemVotos.getNumeroVotos();
                int posicion = damePosicion_votos(partido);
                if (posicion == -1){
                    resultadosTotalVotos.add(vots_itemVotos);
                }else{
                    x_tablaVotos.get(posicion).setNumeroVotos(x_tablaVotos.get(posicion).getNumeroVotos()+votos);
                }
            }
        }
    }
    private int damePosicion_votos(FormacionPolitica partido){
        for (int i=0; i<resultadosTotalVotos.size(); i++ ){
            if(resultadosTotalVotos.get(i).getFormacion().equals(partido)){
                return i;
            }
        }
        return -1;
    }
    
        public void setResultadosTotalEscaños() {
        for (Circunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<ItemEscaños> x_tablaEscaños = circuns.getResultadoEscaños();
            for (ItemEscaños escaños_itemEscaños : x_tablaEscaños){
                FormacionPolitica partido = escaños_itemEscaños.getFormacion();
                int escaños = escaños_itemEscaños.getNumeroEscaños();
                int posicion = damePosicion_escaños(partido);
                if (posicion == -1){
                    resultadosTotalEscaños.add(escaños_itemEscaños);
                }else{
                    x_tablaEscaños.get(posicion).setNumeroEscaños(x_tablaEscaños.get(posicion).getNumeroEscaños()+escaños);
                }
            }
        }
    }
    private int damePosicion_escaños(FormacionPolitica partido){
        for (int i=0; i<resultadosTotalEscaños.size(); i++ ){
            if(resultadosTotalEscaños.get(i).getFormacion().equals(partido)){
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
    public ArrayList<ItemEscaños> getResultadosTotalEscaños() {
        return resultadosTotalEscaños;
    }
    public void setResultadosTotalEscaños(ArrayList<ItemEscaños> resultadosTotalEscaños) {
        this.resultadosTotalEscaños = resultadosTotalEscaños;
    }
    
    
    
//Metodos Publicos
    public void realizarEleccion(boolean votosManuales){
        for(Circunscripcion circunscripcion : eleccionesEnCircunscripcion){
            circunscripcion.calcularResultados(votosManuales);// DEVUELVE LOS ESCAÑOS DE CADA PÀRTIDO POR CIRCUNSCRIPCION
            circunscripcion.calcularListas();
        }
    }
    
    public String imprimirTablaGlobalVotos(){
        return resultadosTotalVotos.toString();
    };
    public String imprimirTablaGlobalescaños(){
        return resultadosTotalEscaños.toString();
    };
    
    public ArrayList<Lista> imrpimirListaElectos() {
        ArrayList<Lista> listaElectos = new ArrayList<>();
        for (Circunscripcion circuns: eleccionesEnCircunscripcion ) {
            ArrayList<Lista> x_listasPartidos = circuns.getListasPartidos();
            for (Lista lista : x_listasPartidos){
                listaElectos.add(lista);
//                FormacionPolitica partido = lista.getFormacionPolitica();
//                ArrayList<Militante> militantes = lista.getDiputados();
//                int posicion = damePosicion_Electos(partido,listaElectos);
//                if (posicion == -1){
//                    listaElectos.add(lista);
//                }else{
//                    listaElectos.get(posicion).getDiputados().addAll(militantes);
//                }
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
    
    
    
    
//    public void imprimirMayorias(){
//        if (resultadosTotalEscaños.getTablaEscaños().size()<5){
//            for(ItemEscaños partido : resultadosTotalEscaños.getTablaEscaños()){
//                if(partido.getNumeroEscaños()>(escaños/2)){
//                    partido.getFormacion().toString();
//                }else{
//                    
//                }
//            }
//        }
//       
//    };
    
    public StringBuilder imprimirMayorias(){
        StringBuilder mayorias = new StringBuilder();
        ArrayList<ItemEscaños> cuatroPartidos = this.cuatroFuerzas();
        for(ItemEscaños partido: cuatroPartidos){
            if(partido.getNumeroEscaños()>(escaños/2)){
               mayorias.append(partido.getFormacion().getNombre()).append(" ").append(partido.getNumeroEscaños()).append("\n");
            }
        }
//        for (int i = 0; i < 4; i++) {
//            for (int j = 1; j < 4; j++) {
//                if(j>i){
//                    if(cuatroPartidos.get(i).getNumeroEscaños()+cuatroPartidos.get(j).getNumeroEscaños()>(escaños/2)){
//                        mayorias.append(cuatroPartidos.get(i).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(i).getNumeroEscaños()).append(" ")
//                                .append(cuatroPartidos.get(j).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(j).getNumeroEscaños()).append(" ");
//                    }
//                }
//            }
//            
//        }
        if(cuatroPartidos.get(0).getNumeroEscaños() + cuatroPartidos.get(1).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(0).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(0).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(1).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(1).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(0).getNumeroEscaños() + cuatroPartidos.get(2).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(0).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(0).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(2).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(2).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(0).getNumeroEscaños() + cuatroPartidos.get(3).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(0).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(0).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(3).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(3).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(1).getNumeroEscaños() + cuatroPartidos.get(2).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(1).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(1).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(2).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(2).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(1).getNumeroEscaños() + cuatroPartidos.get(3).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(1).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(1).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(3).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(3).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(2).getNumeroEscaños() + cuatroPartidos.get(3).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(2).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(2).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(3).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(3).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(0).getNumeroEscaños() + cuatroPartidos.get(1).getNumeroEscaños() + cuatroPartidos.get(2).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(0).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(0).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(1).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(1).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(2).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(2).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(0).getNumeroEscaños() + cuatroPartidos.get(1).getNumeroEscaños() + cuatroPartidos.get(3).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(0).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(0).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(1).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(1).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(3).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(3).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(0).getNumeroEscaños() + cuatroPartidos.get(2).getNumeroEscaños() + cuatroPartidos.get(3).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(0).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(0).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(2).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(2).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(3).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(3).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(1).getNumeroEscaños() + cuatroPartidos.get(2).getNumeroEscaños() + cuatroPartidos.get(3).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(1).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(1).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(2).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(2).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(3).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(3).getNumeroEscaños()).append(" ").append("\n");
        };
        if(cuatroPartidos.get(0).getNumeroEscaños() + cuatroPartidos.get(1).getNumeroEscaños() + cuatroPartidos.get(2).getNumeroEscaños()
                + cuatroPartidos.get(3).getNumeroEscaños()>(escaños/2)){
            mayorias.append(cuatroPartidos.get(0).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(0).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(1).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(1).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(2).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(2).getNumeroEscaños()).append(" ")
            .append(cuatroPartidos.get(3).getFormacion().getNombre()).append(" ").append(cuatroPartidos.get(3).getNumeroEscaños()).append(" ").append("\n");
        };
        return mayorias;
    }
    
   
    private ArrayList<ItemEscaños> cuatroFuerzas(){
        ArrayList<ItemEscaños> copia = (ArrayList) resultadosTotalEscaños.clone(); 
        ArrayList<ItemEscaños> fuerzas = new ArrayList<>();
        if (copia.size()<5){
            return copia;
         }else{        
            int posicion = 0;
            for(int i=0; i<=4;i++){
                int numEscañosMayor = 0; //actualizacion de Numero de escaños para que encuentre el mayor.
                for (int j=0; j<copia.size();){
                    if(copia.get(j).getNumeroEscaños()>numEscañosMayor){
                        numEscañosMayor = copia.get(j).getNumeroEscaños();
                        posicion = j;
                    }
                }
                // Añadir al nuevo ArrayList la posicion i.
                fuerzas.add(copia.get(posicion));
                //borra para poder encontrar el siguiente mayor (hay que clonar resultadosTotalEscaños para no borrar el original, lo he intentado pero no me deja)
                copia.remove(posicion);             
            }
        }
        return fuerzas;
    }

}
