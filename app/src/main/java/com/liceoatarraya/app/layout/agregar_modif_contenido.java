package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.liceoatarraya.app.R;

public class agregar_modif_contenido extends AppCompatActivity {
    private Spinner spinner_aggcontenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_modif_contenido);
        //Texto de ejemplo para el spinner
        Spinner spinner_aggcontenido = findViewById(R.id.sp_materia_aggcontenido);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_materias, android.R.layout.simple_spinner_item);
        spinner_aggcontenido.setAdapter(adapter);
    }
}