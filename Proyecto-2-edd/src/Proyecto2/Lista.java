/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto2;

/**
 *
 * @author andresespinoza
 */
public class Lista {
    NodoLista primero;
    NodoLista ultimo;
    
    public Lista(){
       this.primero = null;
       this.ultimo = null;
    }

    public NodoLista getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    public NodoLista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLista ultimo) {
        this.ultimo = ultimo;
    }
    
    
}
