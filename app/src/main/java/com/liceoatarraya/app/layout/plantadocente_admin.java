package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.liceoatarraya.app.R;

public class plantadocente_admin extends AppCompatActivity {
    Button adddocente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantadocente_admin);

        // Boton que me mueva de activity
        adddocente=findViewById(R.id.btn_agregardocente);
        adddocente.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), registrardocente_admin.class);
            startActivityForResult(intent, 0);
        });
    }
}