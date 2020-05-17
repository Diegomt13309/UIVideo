package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class Gato extends AppCompatActivity {


    private CheckBox gato;
    private CheckBox lindo;
    private CheckBox curioso;
    private CheckBox mesquino;
    private Button consulta;
    private static String textoG;
    private FloatingActionMenu menu;
    private FloatingActionButton subMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato);
        gato= (CheckBox) findViewById(R.id.gato);
        lindo= (CheckBox) findViewById(R.id.lindo);
        curioso= (CheckBox) findViewById(R.id.curioso);
        mesquino= (CheckBox) findViewById(R.id.mesquino);
        menu=(FloatingActionMenu)findViewById(R.id.menu);
        subMenu =(FloatingActionButton) findViewById(R.id.subMenu);
    }

    public  void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        String cadena= "";
        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.gato:
                if (checked)
                cadena+="gato";
                break;
            case R.id.lindo:
                if (checked)
                    cadena+="lindo";
                break;
            case R.id.curioso:
                if (checked)
                    cadena+="curioso";
                break;
            case R.id.mesquino:
                if (checked)
                    cadena+="mesquino";
                break;
            default:
                break;
        }

        Toast.makeText(getApplicationContext(), "Se ha seleccionado:"+cadena, Toast.LENGTH_LONG).show();



    }

    public void clickSubMenu(View view) {
        Toast.makeText(getApplicationContext(), "Accesando al  Main Activity", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Gato.this, MainActivity.class);
        Gato.this.startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        //TODO it's not working yet
         Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
        super.onBackPressed();
        }
}

