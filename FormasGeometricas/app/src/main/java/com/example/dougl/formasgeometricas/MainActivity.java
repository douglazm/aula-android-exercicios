package com.example.dougl.formasgeometricas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioG;
    Button btnNext;
    int forma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
    }

    @SuppressLint("ResourceType")
    public void onClickNext (View view) {
        Intent it = new Intent(MainActivity.this, EntradasActivity.class);
        Bundle bundle = new Bundle();

        radioG = findViewById(R.id.radioG);

        switch (radioG.getCheckedRadioButtonId()) {
            case R.id.radioRetangulo:
                forma = R.id.radioRetangulo;
                bundle.putInt("forma", forma);
                it.putExtras(bundle);
                startActivity(it);
                break;
            case R.id.radioTriangulo:
                forma = R.id.radioTriangulo;
                bundle.putInt("forma", forma);
                it.putExtras(bundle);
                startActivity(it);
                break;
            case R.id.radioCirculo:
                forma = R.id.radioCirculo;
                bundle.putInt("forma", forma);
                it.putExtras(bundle);
                startActivity(it);
                break;
            default:

        }
    }
}
