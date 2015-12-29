//pruebajhgjhfjhfgfhgf
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecciones;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author poltatil
 */
public class Auxiliar {
    
    //Ruta en la que se van a guardar los archivos (/data)
    static File ruta = new File("\\data");
    
    // Método para guardar archivos binarios en el disco duro
    // NOTA: Guarda cualquier cosa, sea un Array, String, Integer, Partido Politico, etc.
    public static void Guardar(Object obj, String nombre) throws IOException {
        // Ruta "/data"
        
        // Si la carpeta /data no existe, la creamos
        if (!ruta.isDirectory()){
            ruta.mkdir();
        };
        
        // Escribimos en el disco duro "ruta/archivo"
        FileOutputStream salida = new FileOutputStream(ruta+"\\"+nombre);
        ObjectOutputStream obj_salida = new ObjectOutputStream (salida);

        // Escribimos objeto al disco
        obj_salida.writeObject(obj);
        
        // Cerramos el fichero
        obj_salida.close();
    }
    
    // Método para recuperar archivos binarios del disco duro.
    public static Object Cargar(String nombre) throws IOException {
        
        // Devolvemos lo que haya en el archivo.
        return new ObjectInputStream(new FileInputStream(ruta+"\\"+nombre)).read();
        
        /* Codigo expandido:
        FileInputStream leer = new FileInputStream(ruta+"\\"+nombre);
        ObjectInputStream objeto_leer = new ObjectInputStream(leer);
        Object obj = objeto_leer.read();
        return obj;
        */
    }
    
    
    // Método para cargar la lista de Militantes para un partido a partir de un archivo de texto.
    public static ArrayList<Militante> CargarLista(String nombreArchivo) throws IOException {
        
        // Como el tamaño del archivo a leer puede ser indefinidamente grande, lo hacemos con un buffer
        // (Para no cargar todo a la memoria a la vez)
        BufferedReader leer = new BufferedReader(new FileReader(ruta+"\\"+nombreArchivo));
        
        //Ahora podemos empezar a leer linea por linea, creamos la lista.
        ArrayList<Militante> lista = new ArrayList<Militante>();
        String linea;
        
        //Mientras haya lineas por leer en el archivo, las agregamos a la lista
        while((linea = leer.readLine())!=null){
            lista.add(new Militante(linea));
        }
               
        return lista;
    }
}
