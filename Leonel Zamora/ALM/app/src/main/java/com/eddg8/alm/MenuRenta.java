package com.eddg8.alm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.xmlpull.v1.XmlPullParser;

public class MenuRenta extends AppCompatActivity {
    String id;
    String idusuario;
    String nombre;
    String descripcion;
    String estado1;

    //contadores
    int nname=0;
    int contid;
    int articulo=0;
    int nombre1=0;
    int descripcion1=0;
    int estado=0;

    int contusuario=1;

    //cantidad de productos
    int tamaño;

    static  Lista listaProductos = new Lista();
    Spinner s;
    static Poductos []po;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_renta);
        s = (Spinner) findViewById(R.id.spinner_producto);
        llenarSpinner();
    }

    public void llenarSpinner(){
        XmlPullParser parser = Xml.newPullParser();
        try {
            File xml = new File("/sdcard/productos.xml");
            FileInputStream fli = new FileInputStream(xml);
            InputStreamReader st = new InputStreamReader(fli);
            BufferedReader bf = new BufferedReader(st);

            parser.setInput(bf);

            while(parser.nextTag() !=(parser.END_DOCUMENT)){

                if(parser.getName().equals("name")){
                    if(nname == 0) {
                        parser.next();
                        idusuario = parser.getText();
                        nname =1;
                    }else{
                        nname =0;
                    }
                }else if(parser.getName().equals("id")){
                    if(contid == 0){
                        parser.next();
                        id = parser.getText();
                        contid = 1;
                    }else{
                        contid = 0;
                    }
                }else if(parser.getName().equals("nombre")){
                    if(nombre1 == 0){
                        parser.next();
                        nombre = parser.getText();
                        nombre1 = 1;
                    }else{
                        nombre1 = 0;
                    }
                }else if(parser.getName().equals("descripcion")){
                    if(descripcion1 == 0){
                        parser.next();
                        descripcion = parser.getText();
                        descripcion1 = 1;
                    }else{
                        descripcion1 = 0;
                    }
                }else if(parser.getName().equals("estado")){
                    if(estado == 0){
                        parser.next();
                        estado1 = parser.getText();
                        estado = 1;
                    }else{
                        estado = 0;
                    }
                }else if(parser.getName().equals("articulo")){
                    articulo = 1;
                }else if(parser.getName().equals("articulo") && articulo == 1){
                    articulo = 0;
                    Poductos p = new Poductos(id,nombre,descripcion,estado1,idusuario);
                    listaProductos.insertar(p);
                    tamaño++;
                }
            }
            filSpinner(tamaño);

        }catch (Exception e){
            contusuario = 1;
        }
    }

    public void filSpinner(int tam){
        int size = tam;
        String []products = new String [tam];
        po = new Poductos[tam];
        for(int i=0;i<po.length-1;i++){
            po[i] = listaProductos.extraerInicio();
        }

        for(int j = 0;j<products.length-1;j++){
            products[j] = po[j].id;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,products);
        s.setAdapter(adapter);
    }
}
