package com.eddg8.alm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void abrirMenu(View v){
        String usuario;
        ConexionFlask conexion = new ConexionFlask();
        EditText editorusuario = (EditText) findViewById(R.id.editor_usuario);
        usuario = editorusuario.getText().toString();
        String con = conexion.Insertar(usuario);
        //Intent intent = new Intent(this,MenuUsuario.class);
        //startActivity(intent);
    }
}
