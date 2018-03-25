package com.example.dougl.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CalculadoraIMC extends AppCompatActivity {

    private TextView nome;
    private EditText altura;
    private EditText peso;
    private TextView resultSaudacao;
    private TextView resultNome;
    private TextView resultInfo;
    private TextView resultTextIMC;
    private TextView resultIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc);

        Button btnTabela = (Button) findViewById(R.id.btnTabela);
        nome = (TextView)findViewById(R.id.editNome);
        altura = (EditText)findViewById(R.id.editAltura);
        peso = (EditText)findViewById(R.id.editPeso);
        resultSaudacao = (TextView)findViewById(R.id.textSaudacao);
        resultNome = (TextView)findViewById(R.id.textResultNome);
        resultInfo = (TextView)findViewById(R.id.textResultInfo);
        resultTextIMC = (TextView)findViewById(R.id.textIMC);
        resultIMC = (TextView)findViewById(R.id.textValorIMC);


    }

    public void mostrarTabela(View view) {

        Intent it = new Intent(CalculadoraIMC.this, TabelaActivity.class);
        startActivity(it);
    }

    public void calcularIMC(View view){

        try {

            Float alt = Float.valueOf(altura.getText().toString());
            Float ps = Float.valueOf(peso.getText().toString());
            Float res = ps / (alt*alt);
            NumberFormat formatarFloat= new DecimalFormat("0.00");
            String imc = formatarFloat.format(res);
            resultIMC.setText(imc);

            String n = String.valueOf(nome.getText().toString());
            resultNome.setText(n);

            resultSaudacao.setText(R.string.saudacao);


            switch (categoriaIMC(res)){
                case "ABAIXO":
                    resultInfo.setText(R.string.abaixoPeso);
                    break;
                case "NORMAL":
                    resultInfo.setText(R.string.pesoNormal);
                    break;
                case "SOBREPESO":
                    resultInfo.setText(R.string.sobrepeso);
                    break;
                case "OBESIDADE1":
                    resultInfo.setText(R.string.obesidade1);
                    break;
                case "OBESIDADE2":
                    resultInfo.setText(R.string.obesidade2);
                    break;
                case "OBESIDADE3":
                    resultInfo.setText(R.string.obesidade3);
                    break;
                default:
                    resultInfo.setText("");
            }

            resultTextIMC.setText(R.string.resultIMC);

        } catch (Exception e){

        }

    }

    public void limpar(View view){

        try {

            nome.setText("");
            altura.setText("");
            peso.setText("");

            resultSaudacao.setText("");

            String n = "";
            resultNome.setText(n);

            resultInfo.setText("");

            resultTextIMC.setText("");

            resultIMC.setText("");

            nome.setFocusableInTouchMode(true);
            nome.requestFocus();

        } catch (Exception e){

        }
    }

    public String categoriaIMC (Float imc){

        if (imc >= 0 && imc < 18.5){
            return "ABAIXO";
        }
        else if (imc >= 18.5 && imc < 25) {
            return "NORMAL";
        }
        else if (imc >= 25 && imc < 30) {
            return "SOBREPESO";
        }
        else if (imc >= 30 && imc < 35) {
            return "OBESIDADE1";
        }
        else if (imc >= 35 && imc < 40) {
            return "OBESIDADE2";
        }
        else if (imc >= 40) {
            return "OBESIDADE3";
        }

        return "ERROR";
    }
}
