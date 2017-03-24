package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlos
 */
public class arbolB {

    public nodoB raiz;

    public arbolB() {
        this.raiz = null;
    }

    public void insertarArbol(nodoB raiz, int tiempo) {

        if (raiz == null) {
            nodoB nuevo = new nodoB(tiempo);
            raiz = nuevo;
            raiz.cantidad += 1;
            System.out.println("inserté nuevo");
            System.out.println("NUEVE CANTIDAD RAIZ "+raiz.cantidad);
        } else if (raiz.anterior == null && raiz.siguiente == null) {
            nodoB nuevo = new nodoB(tiempo);
            if (raiz.tiempo < tiempo) {

                System.out.println("uno");
                nuevo.anterior = raiz;
                raiz.siguiente = nuevo;
                raiz.cantidad += 1;
                System.out.println("UNO CANTIDAD RAIZ "+raiz.cantidad);

            } else if (raiz.tiempo > tiempo) {

                System.out.println("dos");
                nuevo.siguiente = raiz;
                raiz.anterior = nuevo;
                raiz = nuevo;
                raiz.cantidad += 2;
                System.out.println("DOS CANTIDAD RAIZ "+raiz.cantidad);

            }
        } else if (raiz != null) {
            if (raiz.cantidad < 4) {
                insertar(raiz, tiempo);
                System.out.println("ya inserté");
            } else if (raiz.cantidad >= 4) {
                insertar(raiz, tiempo);
                particionar(raiz);
                System.out.println("ya particioné ");
            }
        }

    }///FIN METODO INSERTAR ARBOL

    ///*******************************
    public void insertar(nodoB raiz, int tiempo) {
        nodoB nuevo = new nodoB(tiempo);
        nodoB temporal = raiz;

        while (temporal.tiempo < tiempo && temporal.siguiente != null) {
            temporal = temporal.siguiente;
        }

        if (temporal.siguiente != null) {
            System.out.println("siguiente no nulo");
            if (temporal.tiempo < tiempo) {
                System.out.println("tres");
                temporal.siguiente.anterior = nuevo;
                nuevo.siguiente = temporal.siguiente;
                nuevo.anterior = temporal;
                temporal.siguiente = nuevo;
                raiz.cantidad += 1;
                System.out.println("TRES CANTIDAD RAIZ "+raiz.cantidad);
            } else if (temporal.tiempo > tiempo && temporal.anterior != null) {
                System.out.println("cuatro");
                temporal.anterior.siguiente = nuevo;
                nuevo.anterior = temporal.anterior;
                nuevo.siguiente = temporal;
                temporal.anterior = nuevo;
                raiz.cantidad += 1;
                System.out.println("CUATRO CANTIDAD RAIZ "+raiz.cantidad);
            } else if (temporal.anterior == null && temporal.tiempo > tiempo) {
                System.out.println("siete");
                nuevo.siguiente = raiz;
                raiz.anterior = nuevo;
                raiz.cantidad += 1;
                nuevo.cantidad = raiz.cantidad;
                raiz = nuevo;
                System.out.println(" SIETE CANTIDAD RAIZ "+raiz.cantidad);
            }

        } else if (temporal.siguiente == null) {
            System.out.println("siguiente nulo");
            if (temporal.tiempo < tiempo) {
                System.out.println("cinco");
                temporal.siguiente = nuevo;
                nuevo.anterior = temporal;
                raiz.cantidad += 1;
                System.out.println("CINCO CANTIDAD RAIZ "+raiz.cantidad);
            } else if (temporal.tiempo > tiempo && temporal.anterior != null) {
                System.out.println("seis");
                temporal.anterior.siguiente = nuevo;
                nuevo.anterior = temporal.anterior;
                nuevo.siguiente = temporal;
                temporal.anterior = nuevo;
                raiz.cantidad += 1;
                System.out.println("SEIS CANTIDAD RAIZ "+raiz.cantidad);
            }
        } else if (temporal.anterior == null) {
            System.out.println("anterior nulo");
            if (temporal.tiempo > tiempo) {
                System.out.println("ocho");
                nuevo.siguiente = raiz;
                raiz.anterior = nuevo;
                raiz.cantidad += 1;
                nuevo.cantidad = raiz.cantidad;
                raiz = nuevo;
                System.out.println("OCHO    CANTIDAD RAIZ "+raiz.cantidad);
            }
        } else {
            System.out.println("no se inserto");
        }

    }//FIN DE MÉTODO INSERTAR

    ///************************************
    public void particionar(nodoB raiz) {
        System.out.println("Entré a particionar");
        int contador = 0;
        nodoB temporal = raiz;
        while (temporal != null && contador < 2) {
            contador++;
            temporal = temporal.siguiente;
        }
        System.out.println("Estoy particionando  " + temporal.tiempo);
        temporal.cantidad+=1;
        temporal.izquierda = raiz;
        temporal.izquierda.cantidad = 2;
        temporal.derecha = temporal.siguiente;
        temporal.derecha.cantidad = 2;
        temporal.siguiente.anterior = null;
        temporal.anterior.siguiente = null;
        temporal.anterior = null;
        temporal.siguiente = null;
        raiz = temporal;
        System.out.println("Ya igualé raiz a temporal ");
    }

    //*******************************************
    public void recorreInOrder(nodoB raiz) {
        nodoB temporal = raiz;

        if (raiz != null) {
            System.out.print(raiz.tiempo + ", ");
            recorreInOrder(raiz.siguiente);
            recorreInOrder(raiz.izquierda);
            recorreInOrder(raiz.derecha);
            //if(raiz.siguiente!=null){System.out.println("siguientes "+raiz.siguiente.tiempo+", ");}
            //if(raiz.izquierda!=null){System.out.println("izquierda "+raiz.izquierda.tiempo+", ");}
            //if(raiz.derecha!=null){System.out.println("derecha "+raiz.derecha.tiempo+", ");}
        }
    }

    //***************************************
    public void recorrerPreorder() {
        this.recorreInOrder(raiz);
    }

    public void graficarArbolB(nodoB raiz) {
        FileWriter txt = null;
        PrintWriter imp = null;
        try {
            txt = new FileWriter("/home/carlos/NetBeansProjects/servidor_Java_201213194/reportes/arbolb.txt");
            imp = new PrintWriter(txt);
            imp.println("digraph ArbolB{");
            imp.println("\tnode [fontcolor=\"black\", height=0.5, color=\"red\"]\n");
            imp.println("node[shape=box, peripheries=2, color=orange, style= filled]; ");
            imp.println("\tedge [color=\"black\", dir=fordware]\n");
            imp.println("graph [rankdir= UD];");
            //graficarArbolUsuarios2(usuario, imp);
            this.graficarArbolB2(raiz, imp);
            imp.println("}");

        } catch (IOException ex) {
        } finally {
            try {
                if (null != txt) {
                    txt.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        }

    }//FIN DEL METODO GRAFICAR ARBOL B

    public void graficarArbolB2(nodoB raiz, PrintWriter imp) {

        if (raiz != null) {
            nodoB temporal = raiz;
            String cadena = "";
            while (temporal != null) {
                System.out.println("entre al whiel de graficar");
                cadena += temporal.tiempo + "   |   ";
                temporal = temporal.siguiente;
            }

            imp.println("nodo0" + raiz.tiempo + "[style=filled, label= \" " + cadena + "\"];\n");

            //if (raiz.siguiente != null) {
                
                if (raiz.izquierda != null) {
                    imp.println("nodo0" + raiz.tiempo + "->nodo0" + raiz.izquierda.tiempo + ";\n");
                    this.graficarArbolB2(raiz.izquierda, imp);
                }
                if (raiz.derecha != null) {
                    imp.println("nodo0" + raiz.tiempo + "->nodo0" + raiz.derecha.tiempo + ";\n");
                    this.graficarArbolB2(raiz.derecha, imp);
                }
                /*if(raiz.siguiente!=null){
                    //imp.println("nodo0" + raiz.tiempo + "->nodo0" + raiz.siguiente.tiempo + ";\n");
                    this.graficarArbolB2(raiz.siguiente, imp);                    
                }*/
                //this.graficarArbolB2(raiz.siguiente, imp);
            //}
        }

    }
    
    
    
    public void GenerarJPG_B() {
        try {
            Runtime run = Runtime.getRuntime();
            run.exec("dot /home/carlos/NetBeansProjects/arbolb.txt -o /home/carlos/NetBeansProjects/arbolB.png -Tpng");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
