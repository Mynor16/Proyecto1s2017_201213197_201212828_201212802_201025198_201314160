package com.eddg8.alm;

/**
 * Created by Alejandro on 18/03/2017.
 */
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
    public static OkHttpClient webclient = new OkHttpClient();

    public ConexionFlask(){}

    public static  String Insertar(String dato){
        RequestBody formbody  = new FormEncodingBuilder()
                .add("dato",dato)
                .build();
        try{
           URL url = new URL("http://192.168.1.7:5000/hola");
            Request request = new Request.Builder().url(url).post(formbody).build();
            Response response  = webclient.newCall(request).execute();
            String response_string  = response.body().string();
            return response_string;
        }catch (MalformedURLException ex){
            java.util.logging.Logger.getLogger(ConexionFlask.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            java.util.logging.Logger.getLogger(ConexionFlask.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
