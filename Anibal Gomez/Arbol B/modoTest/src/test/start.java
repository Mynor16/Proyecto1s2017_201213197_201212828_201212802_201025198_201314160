/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author carlos
 */
public class start {
    
    public static void main(String [] argumentos){
        lista l= new lista();
        l.escribirDatos();
        l.escribirDatos2();
        l.inicializarArbolesDesdeArchivo();
        l.graficarListaAux();
        l.obtenerJpg();
        l.graficarSistemaArbolesB();
        l.GenerarJPG_B();
        l.asignarValorPesos();
        l.graficarListaAux();
        l.obtenerJpg();
        l.escribirDatosParaGrafo();
    }
    
}
