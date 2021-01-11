package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liceoatarraya.app.R;

public class adminstrarpruebas_maestro extends AppCompatActivity {
    Button addprueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminstrarpruebas_maestro);
        addprueba=findViewById(R.id.btn_agregarprueba);
        addprueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nprueba = new Intent (v.getContext(), crearnuevaprueba_maestro.class);
                startActivityForResult(nprueba, 0);
            }
        });
    }
}