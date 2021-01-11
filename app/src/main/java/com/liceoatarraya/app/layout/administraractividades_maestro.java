package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liceoatarraya.app.R;

public class administraractividades_maestro extends AppCompatActivity {
    Button nuevaactividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administraractividades_maestro);
        nuevaactividad=findViewById(R.id.btn_agregaractividad);
        nuevaactividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nprueba = new Intent (v.getContext(), crearnuevaactividad_maestro.class);
                startActivityForResult(nprueba, 0);
            }
        });

    }
}