package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlos
 */
public class nodoB {
    
    public int posicion;
    public int tiempo;
    public int cantidad;
    public nodoB siguiente;
    public nodoB anterior;
    public nodoB izquierda;
    public nodoB derecha;
    
    //PARA EL NODO DE LISTA
    public nodoB sig;
    public nodoB arbol;
    public String nombreArista;
    public int pesoPromedio;
    
    
    public nodoB(){
        this.posicion=0;
        this.tiempo=0;
        this.cantidad=0;  
        this.pesoPromedio=0;
        this.nombreArista="";
        this.siguiente=null;
        this.anterior=null;
        this.izquierda=null;
        this.derecha=null;      
        this.sig=null;
        this.arbol=null;
        
    }
    
    public nodoB(int tiempo){
        this.posicion=0;
        this.tiempo=tiempo;
        this.cantidad=0;
        this.pesoPromedio=0;
        this.nombreArista="";
        this.siguiente=null;
        this.anterior=null;
        this.izquierda=null;
        this.derecha=null;                
        this.sig=null;
        this.arbol=null;
        
    }
    
    public nodoB(String nombreArista, String aux){
        this.posicion=0;
        this.tiempo=0;
        this.cantidad=0;
        this.pesoPromedio=0;
        this.nombreArista=nombreArista;
        this.siguiente=null;
        this.anterior=null;
        this.izquierda=null;
        this.derecha=null;                
        this.sig=null;
        this.arbol=null;
    }
    
    
  
    
    
}
