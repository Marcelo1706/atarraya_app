package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.liceoatarraya.app.R;

public class versiculo_admin extends AppCompatActivity {
    Button nuevover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versiculo_admin);
        nuevover=findViewById(R.id.btn_agregarversiculo);
        nuevover.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), crearversiculo_admin.class);
            startActivityForResult(intent, 0);
        });
    }
}