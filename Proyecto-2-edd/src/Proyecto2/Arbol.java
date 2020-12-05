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
public class Arbol {
    NodoArbol raiz;
    
    public Arbol(String valor){
        NodoArbol nodoRaiz = new NodoArbol(valor);
        this.raiz = nodoRaiz;
    }
    
}
