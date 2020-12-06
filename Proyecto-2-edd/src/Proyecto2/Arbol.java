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
            Lista porVisitar = new Lista();
            porVisitar.agregarAlFinal(this.raiz);
            NodoArbol navegador;
            while(!porVisitar.esVacia()){
                navegador = porVisitar.sacaDelPrincipio();
                if(navegador.getHijoAfirmativo() != null && navegador.getHijoNegativo() != null){
                    arbol += "["+navegador.getValor() + "] | Si es Negativo-> ["+navegador.getHijoNegativo().getValor()+"] | Si es Afirmativo -> ["+navegador.getHijoAfirmativo().getValor()+"]\n";
                    
                    //Agregar los hijos a la lista
                    porVisitar.agregarAlFinal(navegador.getHijoAfirmativo());
                    porVisitar.agregarAlFinal(navegador.getHijoNegativo());
                    
                }
//                else{
//                    arbol += "["+navegador.getValor()+"] | Animal\n";
//                }
            }
            
        }
        
        return arbol;
    }
    
    public String imprimirParaArchivo(){
        String arbol = "";
        if(this.raiz == null){
            arbol+=",,,\n";
        }
        else{
            //Comienza el recorrido por el arbol
            Lista porVisitar = new Lista();
            porVisitar.agregarAlFinal(this.raiz);
            NodoArbol navegador;
            while(!porVisitar.esVacia()){
                navegador = porVisitar.sacaDelPrincipio();
                if(navegador.getHijoAfirmativo() != null && navegador.getHijoNegativo() != null){
                    
                    arbol+=navegador.getPadre().getValor()+","+navegador.getValor()+","+navegador.getHijoNegativo().getValor()+","+navegador.getHijoAfirmativo().getValor()+"\n";   
                }
            }
        }
        return arbol;
    }
    
    public Lista encuentraRaices(){
        return null;
    }
    
    public NodoArbol getNodoPorValor(String valor){
        
        if(this.raiz == null){
//            JOptionPane.showMessageDialog(null, "El arbol esta vacio, no se pudo encontrar valores");
            return null;
        }
        else{
            //Comienzo a recorrer todos los nodos del arbol hasta conseguir el nodo
            Lista porVisitar = new Lista();
            porVisitar.agregarAlFinal(this.raiz);
            NodoArbol navegador = null;
            boolean finalizar = false;
            NodoArbol nodoObjectivo = null;
            
            while(!finalizar){
                //Sacamos otro elemento de la lista
                if(!porVisitar.esVacia()){
                    navegador = porVisitar.sacaDelPrincipio();
                }
                
                if(navegador.getValor().equals(valor)){
                    finalizar = true;
                    nodoObjectivo = navegador;
                }
                if(navegador.getHijoNegativo() != null){
                    porVisitar.agregarAlFinal(navegador.getHijoNegativo());
                }
                if(navegador.getHijoAfirmativo() != null){
                    porVisitar.agregarAlFinal(navegador.getHijoAfirmativo());
                }
 
                //Si llego al final del recorrido
                if(porVisitar.esVacia()){
                    finalizar = true;
                }
                
            }
            
            return nodoObjectivo;
            
            
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
        
        //Ciclando por el documento
        while(scan.hasNextLine()){
           lineaDelDoc = scan.nextLine();
//            System.out.println(lineaDelDoc);
            
            //Separo cada linea por una coma, que es como los valores estan separados
            String[] infoLinea = lineaDelDoc.split(",");
            
            String valorPadre = infoLinea[0];
            String valorTarget = infoLinea[1];
            String valorHijoNegativo = infoLinea[2];
            String valorHijoAfirmativo = infoLinea[3];
            
            System.out.println("Nodo Padre: "+valorPadre+" | Nodo Target: "+valorTarget+" | Hijo Negativo: "+valorHijoNegativo+" | Hijo Positivio: "+valorHijoAfirmativo);
            
            ///Busca un nodo en el arbol, si no lo consigue (Caso de la raiz) lo crea
            NodoArbol nodoExistente = this.getNodoPorValor(valorTarget);
            NodoArbol nodoTarget;
            if(nodoExistente == null){
               NodoArbol nuevoNodo = new NodoArbol(valorTarget); 
               nodoTarget = nuevoNodo;
               this.raiz = nodoTarget;
//                System.out.println("Nodo raiz ["+nodoTarget.getValor()+"]");
            }
            else{
//                System.out.println("Encontrado nodo por valor: "+nodoExistente.getValor());
                nodoTarget = nodoExistente;
            }
            
            
            
            if(valorTarget.equals("")){
//                JOptionPane.showMessageDialog(null, "Error leyendo archivo, valor de nodo vacio");
            }
            else{
                
                if(valorHijoNegativo.equals("") && valorHijoAfirmativo.equals("")){
//                    System.out.println("El nodo "+valorTarget+" es un nodo hoja");
                }
                else{
                    if(!valorHijoNegativo.equals("")){
                        NodoArbol hijoNegativo = new NodoArbol(valorHijoNegativo);
                        nodoTarget.setHijoNegativo(hijoNegativo);
                        nodoTarget.getHijoNegativo().setPadre(nodoTarget);
//                        System.out.println("    Agregando hijo negativo ["+nodoTarget.getHijoNegativo().getValor()+"]");
                    }
                    if(!valorHijoAfirmativo.equals("")){
                        NodoArbol hijoAfirmativo = new NodoArbol(valorHijoAfirmativo);
                        nodoTarget.setHijoAfirmativo(hijoAfirmativo);
                        nodoTarget.getHijoAfirmativo().setPadre(nodoTarget);
//                        System.out.println("    Agregando hijo afirmativo ["+nodoTarget.getHijoAfirmativo().getValor()+"] del padre ["+nodoTarget.getHijoAfirmativo().getPadre().getValor()+"]");
                    }
                    
                }
            }
           /* El archivo esta estructurado de la siguiente manera:
            *
            * valor del padre [String], valor [String], valor del hijo afirmativo [String], valor del hijo negativo [String] \n
            *
            */
           
        }
        
        
        
        
        
    }
    
    
    
}
