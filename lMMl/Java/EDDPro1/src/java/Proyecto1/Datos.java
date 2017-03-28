/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author lMMl
 */
public class Datos {
    public static OkHttpClient webClient = new OkHttpClient();

    public Datos() {
    }
    public String getString(String metodo, RequestBody formBody){

        try {
            //URL url = new URL("http://192.168.0.21:5000/" + metodo
            //URL url = new URL("http://192.168.43.165:5000/" + metodo);
            URL url = new URL("http://0.0.0.0:5000/" + metodo);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            String response_string = response.body().string();//y este seria el string de las respuesta
            System.out.println("Exito en comunicacion ");
            return response_string;
        } catch (MalformedURLException ex) {
            //java.util.logging.Logger.getLogger(testwebserver.TestWebServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println("Error en comunicacion ");
        }
        return null;
    }
    public String hola(){
        String nombre = "lMMl";
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato", nombre)
                .build();
        String r = getString("metodoWeb", formBody);
        return r;
    }
    public String AgregaraMatriz(String Usuario, String pass, String nom,String depto, String empresa){
            RequestBody formBody = new FormEncodingBuilder()
                .add("user", Usuario)
                .add("password", pass)
                .add("name", nom)
                .add("depto", depto)
                .add("empresa", empresa)
                .build();
            String r = getString("insertarMatriz", formBody); 
            System.out.println(r);
            return r;

            }
    public String VerificarUsuario(String Usuario, String pass, String empresa,String depto){
            RequestBody formBody = new FormEncodingBuilder()
                .add("user", Usuario)
                .add("password", pass)
                .add("empresa", empresa)
                .add("depto", depto)
                .build();
            String r = getString("verificarUsuario", formBody);
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    "+r);
            return r;
            
            }   
    
    public String CrearActivo(String Usuario,String empresa,String depto,String nombre, String descripcion){
            RequestBody formBody = new FormEncodingBuilder()
                .add("user", Usuario)
                .add("empresa", empresa)
                .add("depto", depto)
                .add("nombre", nombre)
                .add("desc", descripcion)    
                .build();
            String r = getString("insertarAVL", formBody);
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    "+r);
            return r;
            
            }  
    
}
