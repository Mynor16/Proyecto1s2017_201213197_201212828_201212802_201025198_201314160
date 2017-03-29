package com.eddg8.alm;

/**
 * Created by Alejandro on 28/03/2017.
 */

public class Nodo {
    public Poductos producto;
    public Nodo siguiente;

    public Nodo(Poductos p, Nodo s){
        producto = p;
        siguiente = s;
    }
}
