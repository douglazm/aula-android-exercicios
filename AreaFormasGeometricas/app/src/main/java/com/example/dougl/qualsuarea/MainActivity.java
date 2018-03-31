package com.example.dougl.qualsuarea;

import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Double pi = 3.14159265359;
    private DecimalFormat df = new DecimalFormat("0.00");
    private EditText base, altura, raio;
    private RadioGroup rgFormas;
    private TextView txtBase, txtAltura, txtRaio, txtArea, txtAreaValor, txtMedida;
    private ImageView imgForma;
    private Button btnCalcular;
    private String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBase = (TextView) findViewById(R.id.txtBase);
        base = (EditText) findViewById(R.id.editBase);

        txtAltura = (TextView) findViewById(R.id.txtAltura);
        altura = (EditText) findViewById(R.id.editAltura);

        txtRaio = (TextView) findViewById(R.id.txtRaio);
        raio = (EditText) findViewById(R.id.editRaio);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        rgFormas = (RadioGroup) findViewById(R.id.radioGroupFormas);

        imgForma = (ImageView) findViewById(R.id.imgForma);
        txtArea = (TextView) findViewById(R.id.txtArea);
        txtAreaValor = (TextView) findViewById(R.id.txtAreaValor);
        txtMedida = (TextView) findViewById(R.id.txtMedida);

        imgForma.setVisibility(View.INVISIBLE);
        txtAreaValor.setVisibility(View.INVISIBLE);
        txtArea.setVisibility(View.INVISIBLE);
        txtMedida.setVisibility(View.INVISIBLE);

        txtBase.setVisibility(View.INVISIBLE);
        base.setVisibility(View.INVISIBLE);
        txtAltura.setVisibility(View.INVISIBLE);
        altura.setVisibility(View.INVISIBLE);
        txtRaio.setVisibility(View.INVISIBLE);
        raio.setVisibility(View.INVISIBLE);
        btnCalcular.setVisibility(View.INVISIBLE);

    }

    public void radioSelecionado(View view) {

        switch (rgFormas.getCheckedRadioButtonId()) {
            case R.id.radioRetangulo:
                imgForma.setImageResource(R.drawable.rectangle);
                imgForma.setColorFilter(getColor(R.color.corVermelho));
                limpar(R.id.radioRetangulo);
                break;
            case R.id.radioTriangulo:
                imgForma.setImageResource(R.drawable.triangle);
                imgForma.setColorFilter(getColor(R.color.corAzul));
                limpar(R.id.radioTriangulo);
                break;
            case R.id.radioCirculo:
                imgForma.setImageResource(R.drawable.circle);
                imgForma.setColorFilter(getColor(R.color.corVerde));
                limpar(R.id.radioCirculo);
                break;
            default:
                imgForma.setVisibility(View.INVISIBLE);
                txtBase.setVisibility(View.INVISIBLE);
                base.setVisibility(View.INVISIBLE);
                txtAltura.setVisibility(View.INVISIBLE);
                altura.setVisibility(View.INVISIBLE);
                txtRaio.setVisibility(View.INVISIBLE);
                raio.setVisibility(View.INVISIBLE);
                btnCalcular.setVisibility(View.INVISIBLE);
                txtAreaValor.setVisibility(View.INVISIBLE);
                txtArea.setVisibility(View.INVISIBLE);
                txtMedida.setVisibility(View.INVISIBLE);
                base.setText("");
                altura.setText("");
                raio.setText("");
        }
    }

    public void limpar (int id) {

        if (id == R.id.radioRetangulo || id == R.id.radioTriangulo) {
            imgForma.setVisibility(View.VISIBLE);
            txtBase.setVisibility(View.VISIBLE);
            base.setVisibility(View.VISIBLE);
            txtAltura.setVisibility(View.VISIBLE);
            altura.setVisibility(View.VISIBLE);
            txtRaio.setVisibility(View.INVISIBLE);
            raio.setVisibility(View.INVISIBLE);
            base.requestFocus();
        } else if (id == R.id.radioCirculo) {
            imgForma.setVisibility(View.VISIBLE);
            txtBase.setVisibility(View.INVISIBLE);
            base.setVisibility(View.INVISIBLE);
            txtAltura.setVisibility(View.INVISIBLE);
            altura.setVisibility(View.INVISIBLE);
            txtRaio.setVisibility(View.VISIBLE);
            raio.setVisibility(View.VISIBLE);
            base.requestFocus();
        }
        base.setText("");
        altura.setText("");
        raio.setText("");
        btnCalcular.setVisibility(View.VISIBLE);
        txtAreaValor.setVisibility(View.INVISIBLE);
        txtArea.setVisibility(View.INVISIBLE);
        txtMedida.setVisibility(View.INVISIBLE);
    }

    public void calculaRetangulo (Double base, Double altura) {
        result = df.format(base*altura);
        txtAreaValor.setVisibility(View.VISIBLE);
        txtArea.setVisibility(View.VISIBLE);
        txtMedida.setVisibility(View.VISIBLE);
        txtArea.setText(R.string.txtArea);
        txtAreaValor.setText(result);
        txtMedida.setText(R.string.txtMedida);
    }

    public void calculaTriangulo (Double base, Double altura) {
        result = df.format((base*altura)/2);
        txtAreaValor.setVisibility(View.VISIBLE);
        txtArea.setVisibility(View.VISIBLE);
        txtMedida.setVisibility(View.VISIBLE);
        txtArea.setText(R.string.txtArea);
        txtAreaValor.setText(result);
        txtMedida.setText(R.string.txtMedida);

    }

    public void calculaCirculo (Double raio) {
        result = df.format(pi*(raio*raio));
        txtAreaValor.setVisibility(View.VISIBLE);
        txtArea.setVisibility(View.VISIBLE);
        txtMedida.setVisibility(View.VISIBLE);
        txtArea.setText(R.string.txtArea);
        txtAreaValor.setText(result);
        txtMedida.setText(R.string.txtMedida);
    }

    public void calculaArea(View view) {

        try {

            if (rgFormas.getCheckedRadioButtonId() == R.id.radioRetangulo || rgFormas.getCheckedRadioButtonId() == R.id.radioTriangulo) {
                try {
                    Double bs = Double.valueOf(base.getText().toString());
                    try {
                        Double alt = Double.valueOf(altura.getText().toString());

                        if (rgFormas.getCheckedRadioButtonId() == R.id.radioRetangulo) {
                            calculaRetangulo(bs, alt);
                        } else {
                            calculaTriangulo(bs, alt);
                        }
                    } catch (Exception e) {
                        altura.setError(getString(R.string.txtErro));
                    }
                } catch (Exception e) {
                    base.setError(getString(R.string.txtErro));
                }
            } else if (rgFormas.getCheckedRadioButtonId() == R.id.radioCirculo) {
                try {
                    Double r = Double.valueOf(raio.getText().toString());
                    calculaCirculo(r);
                } catch (Exception e) {
                    raio.setError(getString(R.string.txtErro));
                }
            } else {
                Toast.makeText(MainActivity.this, getString(R.string.txtErroSelecao), Toast.LENGTH_LONG).show();
            }
        } catch (Exception e){

        }
    }
}
