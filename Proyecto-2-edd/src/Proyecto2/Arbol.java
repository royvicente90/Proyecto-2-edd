/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author andresespinoza
 */
public class Arbol {
    NodoArbol raiz;
    
    public Arbol(String valor){
        NodoArbol nodoRaiz = new NodoArbol(valor);
        this.raiz = nodoRaiz;
    }
    
    public Arbol(){
        this.raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    public String imprimir(){
        String arbol = "";
        if(this.raiz == null){
            arbol = "El arbol esta vacio";
        }
        else{
            //Comienza el recorrido por el arbol
            Lista porVisitar;
            
        }
        
        return arbol;
    }
    
    public Lista encuentraRaices(){
        return null;
    }
    
    public NodoArbol getNodoPorValor(String valor){
        if(this.raiz == null){
            JOptionPane.showMessageDialog(null, "El arbol esta vacio, no se pudo encontrar valores");
            return null;
        }
        else{
            NodoArbol targetNodo = new NodoArbol("El animal vuela?");
            return targetNodo;
            
        }
    }
    
    public void cargarDatos() throws IOException{
        String arbolEnString = this.imprimir();
        File archivoDeArbol = new File("test/arbol.txt");
        FileWriter writer = new FileWriter(archivoDeArbol);
        writer.write(arbolEnString);
        writer.close();
        
    }
    
    public void leerDatos() throws FileNotFoundException{
        File archivoDeArbol = new File("test/arbol.txt");
        Scanner scan = new Scanner(archivoDeArbol);
        String lineaDelDoc = "";
        while(scan.hasNextLine()){
           lineaDelDoc = scan.nextLine();
           /* El archivo esta estructurado de la siguiente manera:
            *
            * valor [String], valor del padre [String], valor del hijo afirmativo [String], valor del hijo negativo [String] \n
            *
            */
           
        }
        
        
        
        
        
    }
    
    
    
}
