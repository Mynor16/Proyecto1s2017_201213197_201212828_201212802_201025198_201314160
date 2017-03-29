package com.eddg8.alm;

/**
 * Created by Alejandro on 28/03/2017.
 */

public class Lista {
    public Nodo inicio;
    public Nodo fin;

    public  Lista(){
        inicio = null;
        fin = null;
    }

    public void insertar(Poductos p){
        Nodo nuevo = new Nodo(p,null);
        if(inicio == null){
            fin = nuevo;
            inicio = fin;
        }else{
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Poductos extraerInicio(){
        Poductos producto = inicio.producto;
        inicio = inicio.siguiente;
        if(inicio == null){
            fin = null;
        }
        return producto;
    }
}
