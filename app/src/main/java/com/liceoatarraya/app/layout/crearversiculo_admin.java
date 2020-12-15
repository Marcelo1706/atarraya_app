package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.liceoatarraya.app.R;

public class crearversiculo_admin extends AppCompatActivity {
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearversiculo_admin);

        //Texto de ejemplo para el spinner
        Spinner spinner = findViewById(R.id.sp_semanaversiculo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_semanas, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }
}