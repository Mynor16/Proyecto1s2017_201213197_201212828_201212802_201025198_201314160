package com.eddg8.alm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_usuario);
    }

    public void abrirRentas(View v){
        Intent renta = new Intent(this,MenuRenta.class);
        startActivity(renta);
    }

    public void abrirDevoluciones(View v){
        Intent devoluciones = new Intent(this,MenuDevoluciones.class);
        startActivity(devoluciones);
    }
}
