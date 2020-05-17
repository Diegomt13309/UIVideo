package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

public class Perro extends AppCompatActivity {

    private ChipGroup chipos;
    private TextView tagss;
    private EditText texto;
    private Button agregar;
    private Button mostrar;
    private String mensaje = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perro);
        tagss=findViewById(R.id.tags);
        texto=findViewById(R.id.input);
        mostrar=findViewById(R.id.show);
        agregar=findViewById(R.id.add);
        chipos = (ChipGroup) findViewById(R.id.reflow_group);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTag(v);
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chipos.getChildCount()>0) {
                    tagss.setText("");
                    mensaje = "";
                    for (int i = 0; i < chipos.getChildCount(); i++) {
                        Chip chip = (Chip) chipos.getChildAt(i);
                        mensaje = mensaje+"#"+chip.getText().toString();
                    }
                    tagss.setText(mensaje);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        //TODO it's not working yet
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
        super.onBackPressed();
    }

    private void addTag(View view){
        final Chip chip= new Chip(this);
        ChipDrawable drawable = ChipDrawable.createFromAttributes(this,null,0,R.style.Widget_MaterialComponents_Chip_Entry);
        chip.setChipDrawable(drawable);
        chip.setCheckable(false);
        chip.setClickable(false);
        chip.setChipIconResource(R.drawable.ic_hastag);
        chip.setIconStartPadding(3f);
        chip.setPadding(60,10,60,10);
        chip.setText(texto.getText().toString());

        chip.setOnCloseIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipos.removeView(chip);
            }
        });
        chipos.addView(chip);
    }
}
