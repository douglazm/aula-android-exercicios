package com.example.dougl.formasgeometricas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class EntradasActivity extends AppCompatActivity {

    private ImageView imgEntrada;
    private EditText editBase, editAltura, editRaio;
    private TextView txtBase, txtAltura, txtRaio;
    private Button btnCalcular;
    private DecimalFormat df = new DecimalFormat("0.00");
    private String result;
    private Double pi = 3.14159265359;
    private int forma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entradas);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        forma = bundle.getInt("forma");

        imgEntrada = findViewById(R.id.imgEntrada);
        editBase = findViewById(R.id.editBase);
        editAltura = findViewById(R.id.editAltura);
        editRaio = findViewById(R.id.editRaio);
        txtBase = findViewById(R.id.txtBase);
        txtAltura = findViewById(R.id.txtAltura);
        txtRaio = findViewById(R.id.txtRaio);
        btnCalcular = findViewById(R.id.btnCalcular);

        txtBase.setVisibility(View.INVISIBLE);
        txtAltura.setVisibility(View.INVISIBLE);
        txtRaio.setVisibility(View.INVISIBLE);
        editBase.setVisibility(View.INVISIBLE);
        editAltura.setVisibility(View.INVISIBLE);
        editRaio.setVisibility(View.INVISIBLE);

        if (forma == R.id.radioRetangulo) {
            imgEntrada.setImageResource(R.drawable.rectangle);
            imgEntrada.setColorFilter(getColor(R.color.corVermelho));
            txtBase.setVisibility(View.VISIBLE);
            editBase.setVisibility(View.VISIBLE);
            txtAltura.setVisibility(View.VISIBLE);
            editAltura.setVisibility(View.VISIBLE);
        } else if (forma == R.id.radioTriangulo) {
            imgEntrada.setImageResource(R.drawable.triangle);
            imgEntrada.setColorFilter(getColor(R.color.corAzul));
            txtBase.setVisibility(View.VISIBLE);
            editBase.setVisibility(View.VISIBLE);
            txtAltura.setVisibility(View.VISIBLE);
            editAltura.setVisibility(View.VISIBLE);
        } else if (forma == R.id.radioCirculo) {
            imgEntrada.setImageResource(R.drawable.circle);
            imgEntrada.setColorFilter(getColor(R.color.corVerde));
            txtRaio.setVisibility(View.VISIBLE);
            editRaio.setVisibility(View.VISIBLE);
        }
    }

    public void calculaRetangulo (Double base, Double altura) {
        result = df.format(base*altura);
    }

    public void calculaTriangulo (Double base, Double altura) {
        result = df.format((base*altura)/2);
    }

    public void calculaCirculo (Double raio) {
        result = df.format(pi*(raio*raio));
    }

    public void onClickResultado (View view) {

        try {
            Intent it = new Intent(EntradasActivity.this, ResultadoActivity.class);
            Bundle bundle = new Bundle();
            if (forma == R.id.radioRetangulo || forma == R.id.radioTriangulo) {
                try {
                    Double bs = Double.valueOf(editBase.getText().toString());
                    try {
                        Double alt = Double.valueOf(editAltura.getText().toString());

                        if (forma == R.id.radioRetangulo) {
                            calculaRetangulo(bs, alt);
                        } else {
                            calculaTriangulo(bs, alt);
                        }
                    } catch (Exception e) {
                        editAltura.setError(getString(R.string.txtErro));
                        return;
                    }
                } catch (Exception e) {
                    editBase.setError(getString(R.string.txtErro));
                    return;
                }
            } else if (forma == R.id.radioCirculo) {
                try {
                    Double r = Double.valueOf(editRaio.getText().toString());
                    calculaCirculo(r);
                } catch (Exception e) {
                    editRaio.setError(getString(R.string.txtErro));
                    return;
                }
            }
            bundle.putString("resultado", result);
            bundle.putInt("forma", forma);
            it.putExtras(bundle);
            startActivity(it);
        } catch (Exception e){

        }
    }
}
