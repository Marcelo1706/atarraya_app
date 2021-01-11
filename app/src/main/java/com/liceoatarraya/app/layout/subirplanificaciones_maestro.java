package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.liceoatarraya.app.R;

public class subirplanificaciones_maestro extends AppCompatActivity {
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subirplanificaciones_maestro);
        //Texto de ejemplo para el spinner
        Spinner spinner = findViewById(R.id.sp_materiaplanificacion);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_materias, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }
}