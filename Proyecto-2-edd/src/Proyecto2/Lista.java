/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author andresespinoza
 */
public class Lista {
    NodoArbol primero;
    NodoArbol ultimo;
    
    public Lista(){
       this.primero = null;
       this.ultimo = null;
    }

    public NodoArbol getPrimero() {
        return primero;
    }

    public void setPrimero(NodoArbol primero) {
        this.primero = primero;
    }

    public NodoArbol getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoArbol ultimo) {
        this.ultimo = ultimo;
    }
    
    public void agregarAlFinal(NodoArbol nuevoNodo){
        nuevoNodo.setSiguiente(null);
        
        if(this.primero == null){
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        }
        else if(this.primero.getSiguiente() == null){
            this.primero.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
        }
        else{
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
        }
//        System.out.println("Agregado al final: "+nuevoNodo.getValor());
//        this.imprimir();
    }
    
    public void imprimir(){
        NodoArbol navegador = this.primero;
        String lista = "";
        if(navegador == null){
            System.out.println("Lista vacia!");
        }
        else{
            while(navegador != null){
                lista += "["+navegador.getValor()+"] -> ";
                navegador = navegador.getSiguiente();
            }
        }
        System.out.println("Lista: "+lista);
    }
    
    public NodoArbol sacaDelPrincipio(){
        NodoArbol targetNodo = null;
        if(this.primero == null){
            JOptionPane.showMessageDialog(null,"Estas extrayendo un elemento de una lista vacia!");
        }
        else if(this.primero.getSiguiente() == null){
            targetNodo = this.primero;
            targetNodo.setSiguiente(null);
            this.primero.setSiguiente(null);
            this.primero = null;
            this.ultimo = null;  
        }
        else{
//            System.out.println(" nodo: "+this.primero.getValor());
            targetNodo = this.primero;
            this.primero = this.primero.getSiguiente();
        }
//        System.out.println("Desapilando "+targetNodo.getValor());
//        this.imprimir();
        
        return targetNodo;
    }

    public boolean esVacia() {
        return this.primero == null;
    }
}
