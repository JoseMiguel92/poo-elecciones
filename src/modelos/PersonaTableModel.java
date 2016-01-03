/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import elecciones.Votantes;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author poltatil
 */

public class PersonaTableModel extends DefaultTableModel {
    public void añadir(Votantes v){
        // Creamos un Array de 4 elementos (NombreApellidos, edad, genero y profesion y lo añadimos)
        super.addRow(new Object[]{v.getNombreApellidos(),v.getEdad(),v.getGenero(),v.getProfesion()});
    }
    

    // Bloqueamos la edición de celdas en la tabla
    @Override
    public boolean isCellEditable(int row, int column) {
        // Da igual la fila y la columna, decimos que NO siempre.
        return false;
    }
    
}

// PRUEBAS
/* 
public class PersonaTableModel extends AbstractTableModel {
       
     private final String nombreColumnas[] = {"Nombre y Apellidos","Edad","Género","Profesión"};
    private Object datos [][];

    public void add(Votantes v){
        Object[] obj = {v.getNombreApellidos(),v.getEdad(),v.getGenero(),v.getProfesion()};

    };
    
    // Numero de columnas
    @Override
    public int getColumnCount(){
        return nombreColumnas.length;
    }
    
    // Numero de filas
    @Override
    public int getRowCount(){
        return datos.length;
    }
    
    //Obtener valor de un cuadro concreto
    @Override
        public Object getValueAt(int fila, int col) {
        return datos[fila][col];
    }
      

} */
