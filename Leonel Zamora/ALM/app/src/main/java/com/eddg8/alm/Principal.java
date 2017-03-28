package com.eddg8.alm;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Principal extends AppCompatActivity {
    //Varible que indica si los datos del usuario estan bien
    static boolean entry = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button button = (Button) findViewById(R.id.btn_ingresar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //variables que guardan la informacion del login para comparar si acepta el inicio de sesion
                String usuario,contraseña,empresa,departamento;
                ConexionFlask conexion = new ConexionFlask();

                //variables para obtener los datos de los edittext correspondientes en e login
                EditText editorusuario = (EditText) findViewById(R.id.editor_usuario);
                EditText editorcontraseña = (EditText) findViewById(R.id.editor_contraseña);
                EditText editorempresa = (EditText) findViewById(R.id.editor_empresa);
                EditText editordepa = (EditText) findViewById(R.id.editor_departamento);

                usuario = editorusuario.getText().toString();
                contraseña = editorcontraseña.getText().toString();
                empresa = editorempresa.getText().toString();
                departamento = editordepa.getText().toString();

                //aca se llama el metodo que inicia la conexion con flask pára verificar los datos
                conexion.Insertar(usuario,contraseña,empresa,departamento);
            }
        });
    }

    //aqui vamos a verificar si esta bien los datos o no y de estar bien se abrira el menu de usuario
    public void abrirMenu(View v){
        if(entry == true) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Datos Correctos");
            AlertDialog alerta = alert.create();
            alerta.show();
            Intent intent = new Intent(this, MenuUsuario.class);
            startActivity(intent);
        }else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Datos Incorrectos");
            AlertDialog alerta = alert.create();
            alerta.show();
        }
    }

    public void combrabarDatos(boolean entrar){
        entry = entrar;
    }
}
