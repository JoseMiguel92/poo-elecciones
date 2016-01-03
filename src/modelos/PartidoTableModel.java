/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author poltatil
 */
public class PartidoTableModel extends DefaultTableModel{
    public PartidoTableModel(){
        super(
                new Object [][] {},
                new String [] {"Nombre", "Siglas"}
        );
    }
        // Bloqueamos la edición de celdas en la tabla
    @Override
    public boolean isCellEditable(int row, int column) {
        // Da igual la fila y la columna, decimos que NO siempre.
        return false;
    }
}
