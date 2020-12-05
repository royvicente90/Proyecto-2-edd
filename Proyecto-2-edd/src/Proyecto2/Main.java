/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author royvi
 */
public class Main {
    
    public static void main(String [] args) throws FileNotFoundException, IOException {
        
        
        System.out.println("-- Inicializando programa --");
        Arbol nuevoArbol = new Arbol();
        nuevoArbol.leerDatos();
        nuevoArbol.cargarDatos();
        MainModal newModal = new MainModal(nuevoArbol);
        newModal.setVisible(true);
        
    }
    
}
