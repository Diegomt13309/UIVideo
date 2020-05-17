package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private  Button BtnPerro1;
    private ImageButton BtnGato1;
    private RadioButton radioGato;
    private RadioButton radioPerro;
    private ToggleButton toggle;
    private Button enviar;
    private Switch switchbtn;
    private TableLayout tabl;
    private TextView textOp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se inicializan los botones
        BtnPerro1=findViewById(R.id.perro1);
        BtnGato1= (ImageButton) findViewById(R.id.gato1);
       radioGato = (RadioButton) findViewById(R.id.radio_gato);
        radioPerro = (RadioButton) findViewById(R.id.radio_perro);
        toggle = (ToggleButton) findViewById(R.id.toggleButton);
        enviar =(Button) findViewById(R.id.enviar);
        switchbtn= (Switch) findViewById(R.id.switchbtn);
        tabl = (TableLayout) findViewById(R.id.tabla);
        textOp =(TextView) findViewById(R.id.textOP);


        BtnPerro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Accesando a Perro", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Perro.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

        BtnGato1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Accesando a Gatos", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Gato.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    BtnPerro1.setEnabled(true);
                    BtnGato1.setEnabled(true);
                    radioGato.setEnabled(true);
                    radioPerro.setEnabled(true);
                    enviar.setEnabled(true);
                } else {
                    BtnPerro1.setEnabled(false);
                    BtnGato1.setEnabled(false);
                    radioGato.setEnabled(false);
                    radioPerro.setEnabled(false);
                    enviar.setEnabled(false);
                }
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
            });

        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tabl.setBackgroundColor(Color.WHITE);
                    switchbtn.setTextColor(Color.BLACK);
                    radioGato.setTextColor(Color.BLACK);
                    radioPerro.setTextColor(Color.BLACK);
                    textOp.setTextColor(Color.BLACK);
                }
                else{
                    tabl.setBackgroundColor(Color.BLACK);
                    switchbtn.setTextColor(Color.WHITE);
                    radioGato.setTextColor(Color.WHITE);
                    radioPerro.setTextColor(Color.WHITE);
                    textOp.setTextColor(Color.WHITE);

                }
            }
        });



    }

    public void validar(){

        if (radioGato.isChecked()){
            Toast.makeText(this, "Se han seleccionado Gatos", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, Gato.class);
            MainActivity.this.startActivity(intent);
            finish();
        }
        if (radioPerro.isChecked()){
            Toast.makeText(this, "Se han seleccionado Perros", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, Perro.class);
            MainActivity.this.startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "No se ha seleccionado ningun elemento", Toast.LENGTH_LONG).show();
        }


    }





    }
