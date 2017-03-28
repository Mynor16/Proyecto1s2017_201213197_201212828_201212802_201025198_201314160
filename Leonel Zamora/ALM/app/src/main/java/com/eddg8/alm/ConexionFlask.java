package com.eddg8.alm;

/**
 * Created by Alejandro on 18/03/2017.
 */
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;


public class ConexionFlask {
    //Variable para la conexion
    public static OkHttpClient webclient = new OkHttpClient();
    //variables que se manda como parametra al metodo post
    String dato,contraseñan,empresa,departamento;
    //variable que recibe la respueta del webservice para saber si los datos estan correctos
    String respuesta;
    //variable para saber si se puede entrar al menu principal
    boolean entrar = false;

    public void Insertar(String u,String c,String e,String d){
        dato = u;
        contraseñan = c;
        empresa = e;
        departamento = d;

        //Aqui se ejecuta e inica la conexion
        Connexion con = new Connexion();
        con.execute();
    }

    private class Connexion extends AsyncTask<Void,Void,Void>{
        String response_string = "";
        @Override
        protected Void doInBackground(Void... params) {
            RequestBody formbody  = new FormEncodingBuilder()
                    .add("p",dato)
                    .add("p2",contraseñan)
                    .add("p3",empresa)
                    .add("p4",departamento)
                    .build();
            try{
                Request request = new Request.Builder().url(url).post(formbody).build();
                Response response  = webclient.newCall(request).execute();
                response_string  = response.body().string();
            }catch (MalformedURLException ex){
                java.util.logging.Logger.getLogger(ConexionFlask.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex){
                java.util.logging.Logger.getLogger(ConexionFlask.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            respuesta = response_string;
            Principal p = new Principal();
            if(respuesta.equals("True")){
                entrar = true;
                p.combrabarDatos(entrar);
            }else{
                entrar = false;
                p.combrabarDatos(entrar);
            }
            super.onPostExecute(aVoid);
        }
    }
}
