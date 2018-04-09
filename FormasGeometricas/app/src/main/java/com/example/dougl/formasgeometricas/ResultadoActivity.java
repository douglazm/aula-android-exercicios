package com.example.dougl.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends AppCompatActivity {

    private String resultado;
    private TextView txtArea, txtResultado, txtMedida;
    private ImageView imgResultado;
    private int forma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imgResultado = findViewById(R.id.imgResultado);
        txtArea = findViewById(R.id.txtArea);
        txtResultado = findViewById(R.id.txtResultado);
        txtMedida = findViewById(R.id.txtMedida);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        resultado = bundle.getString("resultado");
        forma = bundle.getInt("forma");

        if (forma == R.id.radioRetangulo) {
            imgResultado.setImageResource(R.drawable.rectangle);
            imgResultado.setColorFilter(getColor(R.color.corVermelho));
        } else if (forma == R.id.radioTriangulo) {
            imgResultado.setImageResource(R.drawable.triangle);
            imgResultado.setColorFilter(getColor(R.color.corAzul));
        } else if (forma == R.id.radioCirculo) {
            imgResultado.setImageResource(R.drawable.circle);
            imgResultado.setColorFilter(getColor(R.color.corVerde));
        }

        txtArea.setVisibility(View.VISIBLE);
        txtResultado.setVisibility(View.VISIBLE);
        txtMedida.setVisibility(View.VISIBLE);
        txtResultado.setText(resultado);
    }
}
