package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.liceoatarraya.app.R;

public class EditarOrientadorActivity extends AppCompatActivity {

   Spinner spDocentes;
   Spinner spGrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_orientador);

        spDocentes = findViewById(R.id.spDocentes);
        spGrados = findViewById(R.id.spGrados);

        String[] docentes = {"Docente 1","Docente 2","Docente 3"};
        String[] grados = {"Grado 1", "Grado 2", "Grado 3"};

        ArrayAdapter<String> spAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, docentes);

        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDocentes.setAdapter(spAdapter);

        ArrayAdapter<String> spAdapterGrados = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, grados);

        spAdapterGrados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGrados.setAdapter(spAdapterGrados);
    }
}