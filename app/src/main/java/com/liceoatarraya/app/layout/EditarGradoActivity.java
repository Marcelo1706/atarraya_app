package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.liceoatarraya.app.R;

public class EditarGradoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_grado);
        setTitle("Editar Grado");
    }
}