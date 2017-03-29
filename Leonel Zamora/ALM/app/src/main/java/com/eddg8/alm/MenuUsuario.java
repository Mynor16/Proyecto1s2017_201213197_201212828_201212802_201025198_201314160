package com.eddg8.alm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class MenuUsuario extends AppCompatActivity {
    static String fileXml;
    public static OkHttpClient webclient = new OkHttpClient();
    String archivoxml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
        Conexion2 conexion2 = new Conexion2();
        conexion2.execute();
    }

    public void abrirRentas(View v){
        Intent renta = new Intent(this,MenuRenta.class);
        startActivity(renta);
    }

    public void abrirDevoluciones(View v){
        Intent devoluciones = new Intent(this,MenuDevoluciones.class);
        startActivity(devoluciones);
    }

    private class Conexion2 extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            RequestBody formbody  = new FormEncodingBuilder()
                    .add("p","request")
                    .build();
            try{
                URL url = new URL("http://192.168.1.7:5000/archivoXML");
                Request request = new Request.Builder().url(url).post(formbody).build();
                Response response  = webclient.newCall(request).execute();
                archivoxml  = response.body().string();
            }catch (MalformedURLException ex){
                java.util.logging.Logger.getLogger(ConexionFlask.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex){
                java.util.logging.Logger.getLogger(ConexionFlask.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            crearArchivo(archivoxml);
            super.onPostExecute(aVoid);
        }
    }




    public void crearArchivo(String xml){
        fileXml = xml;
        File file = new File("/sdcard/productos.xml");
        try{
            if(file.exists()){
                FileOutputStream fot = new FileOutputStream(file);
                OutputStreamWriter op = new OutputStreamWriter(fot);
                op.append(fileXml);
                op.close();
                fot.close();
                Toast.makeText(getBaseContext(),"si se escribio en el xml el la SD 'productos.xml'",Toast.LENGTH_LONG).show();
            }else{
                file.createNewFile();
                FileOutputStream fot = new FileOutputStream(file);
                OutputStreamWriter op = new OutputStreamWriter(fot);
                op.append(fileXml);
                op.close();
                fot.close();
                Toast.makeText(getBaseContext(),"si se creo el xml el la SD 'productos.xml'",Toast.LENGTH_LONG).show();
            }
        }catch(Exception e){
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
