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
public class NodoArbol {
    String valor;
    NodoArbol hijoAfirmativo;
    NodoArbol hijoNegativo;
    NodoArbol padre;
    NodoArbol siguiente;
    
    public NodoArbol(String pregunta){
        this.valor = pregunta;
        this.hijoAfirmativo = null;
        this.hijoNegativo =null;
        this.padre = null; 
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoArbol getHijoAfirmativo() {
        return hijoAfirmativo;
    }

    public void setHijoAfirmativo(NodoArbol hijoAfirtmativo) {
        this.hijoAfirmativo = hijoAfirtmativo;
    }

    public NodoArbol getHijoNegativo() {
        return hijoNegativo;
    }

    public void setHijoNegativo(NodoArbol hijoNegativo) {
        this.hijoNegativo = hijoNegativo;
    }

    public NodoArbol getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }

    public NodoArbol getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoArbol siguiente) {
        this.siguiente = siguiente;
    }
    
    public boolean esHoja(){
        return this.hijoAfirmativo == null && this.hijoNegativo == null;
    }
    
}
