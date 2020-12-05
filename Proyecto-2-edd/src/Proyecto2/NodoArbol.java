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
    NodoArbol hijoAfirtmativo;
    NodoArbol hijoNegativo;
    NodoArbol padre;
    
    public NodoArbol(String pregunta){
        this.valor = pregunta;
        this.hijoAfirtmativo = null;
        this.hijoNegativo =null;
        this.padre = null; 
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public NodoArbol getHijoAfirtmativo() {
        return hijoAfirtmativo;
    }

    public void setHijoAfirtmativo(NodoArbol hijoAfirtmativo) {
        this.hijoAfirtmativo = hijoAfirtmativo;
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
    
    
    
    
    
}
