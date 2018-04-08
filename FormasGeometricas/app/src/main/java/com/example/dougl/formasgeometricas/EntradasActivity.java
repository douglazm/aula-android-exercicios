package com.example.dougl.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EntradasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entradas);
    }

    public void onClickResultado (View view) {
        Intent it = new Intent(EntradasActivity.this, ResultadoActivity.class);
        startActivity(it);
    }
}
