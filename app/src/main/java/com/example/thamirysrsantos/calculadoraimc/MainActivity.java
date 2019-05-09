package com.example.thamirysrsantos.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String Mensagem = "com.example. imccal.Mensagem";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calcular (View view) {
        EditText edPeso = findViewById(R.id.txtPeso);
        EditText edAltura = findViewById(R.id.txtAltura);

        TextView textResultado = findViewById(R.id.tvResultado);

        String situacao;

        Double peso = Double.parseDouble(edPeso.getText().toString());
        Double altura = Double.parseDouble(edAltura.getText().toString());
        Double calculo = peso / (altura * altura);

        situacao = "Resultado: " + String.format ("%.2f", calculo);


        if (calculo < 18.5) {
            //Alerta abaixo de peso
            situacao =  String.format("%.2f", calculo) + " Abaixo do peso";
        }
        else if (calculo > 25) {
            //Alerta acima do peso
            situacao =  String.format("%.2f", calculo) + " Acima do peso";
        }
        else {
            //Alerta peso ideal
            situacao =  String.format("%.2f", calculo) + " Peso ideal";
        }

        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra(Mensagem, situacao);
        startActivity(intent);
    }


}
