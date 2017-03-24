/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import analizador.lexico;
import analizador.sintactico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import analizador.sintactico;
import parseo.parser;

/**
 *
 * @author carlos
 */
public class lista {

    nodoB inicioLista;
    String directorioAux = "/home/carlos/NetBeansProjects/modoTest/aux.txt";
    String directorioGrafo="/home/carlos/NetBeansProjects/modoTest/grafoD.txt";
    nodoB temporal;
    nodoB temporales=null;

    public lista() {
        this.inicioLista = null;
        //this.arb = new arbolB();
        temporal = null;
    }

    public nodoB insertarLista(String nombre, nodoB nuevos) {
        nodoB nuevo = nuevos;
        if (inicioLista == null) {
            inicioLista = nuevo;
            System.out.println("NUEVO EN LISTA---->>>");
        } else {
            nodoB temporal = inicioLista;
            while (temporal.siguiente != null) {
                temporal = temporal.siguiente;
            }
            temporal.siguiente = nuevo;
            System.out.println("No nuevo en lista--->>>");
        }
        return nuevo;

    }//FIN DE MÉTODO INSERTARLISTA

    public void insertarPunteroArbol(int tiempo, String nombre) {
        nodoB temporal = inicioLista;
        boolean encontrado = false;
        while (encontrado == false && temporal != null) {

            if (temporal.nombreArista.equals(nombre)) {
                //arb.insertarArbol(temporal.arbol, tiempo);
            }

            temporal = temporal.siguiente;
        }
    }//FIN DE INSERTAR_PUNTERO_ARBOL

    //METODO PARA LEER LOS DATOS EN EL ARCHIVO DE ENTRADA Y ESCRIBIRLO EN FORMATO A,B EN 
    //LUGAR DE A->B
    public void escribirDatos() {
        String le = leerArchivo();//ACÁ SE DEVUELVE LA CADENA LEIDA EN EL ARCHIVO
        lexico l = new lexico(new BufferedReader(new StringReader(le)));
        parser s = new parser(l);
        try {
            s.parse();
        } catch (Exception ex) {
        }
    }//FIN DE ESCRIBIR_DATOS

    //MÉTODO QUE SIRVE PARA LEER EL ARCHIVO CON LAS NOTACIONES DEL GRAFO DESDE EL DIRECTORIO DEL PAQUETE
    public String leerArchivo() {
        String texto, entrada = "";
        try {
            File abre = new File("/home/carlos/NetBeansProjects/modoTest/entrada1.txt");
            if (abre != null) {
                FileReader archivo = new FileReader(abre);
                BufferedReader leer = new BufferedReader(archivo);
                while ((texto = leer.readLine()) != null) {
                    entrada += texto + "\n";
                }
                leer.close();
            }
        } catch (IOException ex) {
        }
        return entrada;
    }

    public void inicializarListaDesdeArchivo() {
        String datos[] = null;
        String texto, entrada = "";
        int pos = 0;
        try {
            File abre = new File("/home/carlos/NetBeansProjects/modoTest/datos.txt");
            if (abre != null) {
                FileReader archivo = new FileReader(abre);
                BufferedReader leer = new BufferedReader(archivo);
                while ((texto = leer.readLine()) != null) {
                    entrada += texto + "\n";
                }

                datos = entrada.split(",");
                while (pos < datos.length - 1) {
                    String origen = datos[pos];
                    String destino = datos[pos + 1];
                    pos += 2;
                    String cad = origen + "->" + destino;
                    System.out.println("Obteniendo--->>>");
//                    this.insertarLista(cad);

                }
                leer.close();
            }
        } catch (IOException ex) {
            System.out.println("Error en inicializarLista " + ex);
        }

    }//FIN DE INICIALIZAR LISTA DESDE ARCHIVO

    public void graficarListaAux() {
        FileWriter txt = null;
        PrintWriter imp = null;
        try {
            txt = new FileWriter(directorioAux);
            imp = new PrintWriter(txt);
            imp.println("digraph hash{");
            imp.println("\tnode [fontcolor=\"black\", height=0.5, color=\"red\"]\n");
            imp.println("node[shape=box, peripheries=2, color=orange, style= filled]; ");
            imp.println("\tedge [color=\"black\", dir=fordware]\n");
            imp.println("graph [rankdir= UD];");

            if (inicioLista == null) {
                System.out.println("Ni un solo dato existe en la lista simplemente enlazada");

            } else {
                System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
                System.out.println("Existen datos");
                nodoB temporal = inicioLista;
                int contador = 0;
                int cont;
                while (temporal != null) {//Bucle while para recorrer y escribir el label o etiqueta que contendra los datos
                    imp.println("nodo0" + contador + "[label=\"Arista : " + temporal.nombreArista+"\nPeso "+temporal.pesoPromedio + "\"];\n");
                    //if (temporal.siguiente != null) {//Si el siguiente del temporal existe, se escribe un apuntador hacia él en graphviz
                    cont = contador + 1;
                    imp.println("nodo0" + contador + "->nodo0" + cont + ";\n");
                    //}
                    contador += 1;
                    temporal = temporal.siguiente;          //Se actualiza el puntero de temporal al siguiente 
                }
            }

            imp.println("}");

        } catch (IOException ex) {
            System.out.println("En graficarLista : " + ex);
        } finally {
            try {
                if (null != txt) {
                    txt.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
                System.out.println("Dentor de graficarLista " + ex1);
            }
        }

    }

    //Metodo empleado para generar la imagen desde el cmd de windows 
    public void obtenerJpg() {
        try {
            Runtime run = Runtime.getRuntime();
            run.exec("dot /home/carlos/NetBeansProjects/modoTest/aux.txt -o /home/carlos/NetBeansProjects/modoTest/aux.jpg -Tjpg");
        } catch (Exception ex) {
            System.out.println("Ocurrió un error "+ ex);
        }
    }//FIN DE METODO OBTENER IMAGEN

    public void escribirDatos2() {
        String le = leerArchivo2();//ACÁ SE DEVUELVE LA CADENA LEIDA EN EL ARCHIVO
        lexico l = new lexico(new BufferedReader(new StringReader(le)));
        sintactico s = new sintactico(l);
        try {
            s.parse();
        } catch (Exception ex) {
        }
    }//FIN DE ESCRIBIR_DATOS

    //MÉTODO QUE SIRVE PARA LEER EL ARCHIVO CON LAS NOTACIONES DEL GRAFO DESDE EL DIRECTORIO DEL PAQUETE
    public String leerArchivo2() {
        String texto, entrada = "";
        try {
            File abre = new File("/home/carlos/NetBeansProjects/modoTest/entrada2.txt");
            if (abre != null) {
                FileReader archivo = new FileReader(abre);
                BufferedReader leer = new BufferedReader(archivo);
                while ((texto = leer.readLine()) != null) {
                    entrada += texto + "\n";
                }
                leer.close();
            }
        } catch (IOException ex) {
        }
        return entrada;
    }

    public void inicializarArbolesDesdeArchivo() {
        String datos[] = null;
        String texto, entrada = "";
        int pos = 0;
        try {
            File abre = new File("/home/carlos/NetBeansProjects/modoTest/datos2.txt");
            if (abre != null) {
                FileReader archivo = new FileReader(abre);
                BufferedReader leer = new BufferedReader(archivo);
                while ((texto = leer.readLine()) != null) {
                    entrada += texto + "\n";
                }
                leer.close();
                datos = entrada.split(",");
                
                while (pos < datos.length - 1) {
                    char c[] = datos[pos].toCharArray();
                    if ((c[0] >= (char) 65 && c[0] <= (char) 90) || (c[0] >= (char) 97 && c[0] <= (char) 122)) {
                        System.out.println("reconociendo " + c[0]);
                        String nom = datos[pos] + "->" + datos[pos + 1];
                        System.out.println("nombre " + nom);
                        int tiempo = Integer.parseInt(datos[pos+2]);
                        nodoB nuevoL = new nodoB(nom,"");
                        temporales=insertarLista(nom, nuevoL);
                        System.out.println("temp "+temporales);
                        temporales.arbol=this.insertarArbol(nuevoL.arbol, tiempo);
                        System.out.println("temp 2 "+temporales.arbol);
                        pos+=3;

                    } else {
                        int tiempo = Integer.parseInt(datos[pos]);
                        temporales.arbol=this.insertarArbol(temporales.arbol, tiempo);
                        System.out.println("Recorriendo el else del while");
                        System.out.println("direccion "+temporales);     
                        System.out.println("direccion puntero "+temporales);
                        pos+=1;
                        //                        insertarArbol(temporal.arbol, val);
                    }

                }

            }
        } catch (IOException ex) {
            System.out.println("Error en inicializarLista " + ex);
        }

    }//FIN DE INICIALIZAR LISTA DESDE ARCHIVO

    public nodoB insertarArbol(nodoB raiz, int tiempo) {

        if (raiz == null) {
            nodoB nuevo = new nodoB(tiempo);
            raiz = nuevo;
            raiz.cantidad += 1;
            System.out.println("inserté nuevo");
            System.out.println("NUEVA CANTIDAD RAIZ " + raiz.cantidad);
        } else if (raiz.anterior == null && raiz.siguiente == null) {
            nodoB nuevo = new nodoB(tiempo);
            if (raiz.tiempo < tiempo) {

                System.out.println("uno");
                nuevo.anterior = raiz;
                raiz.siguiente = nuevo;
                raiz.cantidad += 1;
                System.out.println("UNO CANTIDAD RAIZ " + raiz.cantidad);

            } else if (raiz.tiempo > tiempo) {

                System.out.println("dos");
                nuevo.siguiente = raiz;
                raiz.anterior = nuevo;
                raiz = nuevo;
                raiz.cantidad += 2;
                System.out.println("DOS CANTIDAD RAIZ " + raiz.cantidad);

            }
        } else if (raiz != null) {
            if (raiz.cantidad < 4) {
                raiz=insertar(raiz, tiempo);
                System.out.println("ya inserté");
            } else if (raiz.cantidad >= 4) {
                insertar(raiz, tiempo);
                raiz=particionar(raiz);
                System.out.println("ya particioné ");
            }
        }
        return raiz;

    }///FIN METODO INSERTAR ARBOL
     
    ///*******************************
    public nodoB insertar(nodoB raiz, int tiempo) {
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
                System.out.println("TRES CANTIDAD RAIZ " + raiz.cantidad);
            } else if (temporal.tiempo > tiempo && temporal.anterior != null) {
                System.out.println("cuatro");
                temporal.anterior.siguiente = nuevo;
                nuevo.anterior = temporal.anterior;
                nuevo.siguiente = temporal;
                temporal.anterior = nuevo;
                raiz.cantidad += 1;
                System.out.println("CUATRO CANTIDAD RAIZ " + raiz.cantidad);
            } else if (temporal.anterior == null && temporal.tiempo > tiempo) {
                System.out.println("siete");
                nuevo.siguiente = raiz;
                raiz.anterior = nuevo;
                raiz.cantidad += 1;
                nuevo.cantidad = raiz.cantidad;
                raiz = nuevo;
                System.out.println(" SIETE CANTIDAD RAIZ " + raiz.cantidad);
            }

        } else if (temporal.siguiente == null) {
            System.out.println("siguiente nulo");
            if (temporal.tiempo < tiempo) {
                System.out.println("cinco");
                temporal.siguiente = nuevo;
                nuevo.anterior = temporal;
                raiz.cantidad += 1;
                System.out.println("CINCO CANTIDAD RAIZ " + raiz.cantidad);
            } else if (temporal.tiempo > tiempo && temporal.anterior != null) {
                System.out.println("seis");
                temporal.anterior.siguiente = nuevo;
                nuevo.anterior = temporal.anterior;
                nuevo.siguiente = temporal;
                temporal.anterior = nuevo;
                raiz.cantidad += 1;
                System.out.println("SEIS CANTIDAD RAIZ " + raiz.cantidad);
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
                System.out.println("OCHO    CANTIDAD RAIZ " + raiz.cantidad);
            }
        } else {
            System.out.println("no se inserto");
        }
        return raiz;

    }//FIN DE MÉTODO INSERTAR

    ///************************************
    public nodoB particionar(nodoB raiz) {
        System.out.println("Entré a particionar");
        int contador = 0;
        nodoB temporal = raiz;
        while (temporal != null && contador < 2) {
            contador++;
            temporal = temporal.siguiente;
        }
        System.out.println("Estoy particionando  " + temporal.tiempo);
        temporal.cantidad += 1;
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
        return raiz;
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

    public void graficarArbolB(nodoB raiz) {
        FileWriter txt = null;
        PrintWriter imp = null;
        try {
            txt = new FileWriter("/home/carlos/NetBeansProjects/modoTest/arbolb.txt");
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
            System.out.println(cadena);

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
            run.exec("dot /home/carlos/NetBeansProjects/modoTest/arbolb.txt -o /home/carlos/NetBeansProjects/modoTest/arbolB.png -Tpng");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    public void graficarSistemaArbolesB(){
        
        if(inicioLista.arbol==null){
            System.out.println("El sitema de árboles B está vacío");
        }
        else{
            
            System.out.println("nombreLista "+ inicioLista.nombreArista);
            this.graficarArbolB(inicioLista.arbol);
            
        }
        
    }
    
    
    public void asignarValorPesos(){
        nodoB temporal=inicioLista;
        nodoB temporalRaiz=temporal.arbol;
        int acumulado=0;
        int contador=0;
        while(temporal!=null){
            temporalRaiz=temporal.arbol;
            while(temporalRaiz!=null){
                acumulado+=temporalRaiz.tiempo;                                
                contador++;
                temporalRaiz=temporalRaiz.siguiente;                                
            }
            temporal.pesoPromedio=(acumulado)/contador;
            System.out.println("Acumulador "+acumulado+" Temporal peso promedio "+temporal.pesoPromedio);
            contador=acumulado=0;
            temporal=temporal.siguiente;
            System.out.println(55/13);
        }
    }
    
    
    public void escribirDatosParaGrafo(){
        nodoB temporal =inicioLista;
        FileWriter txt = null;
        PrintWriter imp = null;
        try {
            txt = new FileWriter(directorioGrafo);
            imp = new PrintWriter(txt);
            
            while(temporal!=null){
                char c[]=temporal.nombreArista.toCharArray();
                char origen =c[0];
                char destino=c[3];
                imp.println(origen+","+destino+","+temporal.pesoPromedio+",");
                temporal=temporal.siguiente;
            }
            

        } catch (IOException ex) {
            System.out.println("Excepcion : " + ex + "\n");
        }//FIN DEL TRY CATCH
        finally {
            try {
                if (null != txt) {
                    txt.close();
                }
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
    }}
    
    

}
