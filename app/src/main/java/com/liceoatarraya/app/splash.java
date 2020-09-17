package com.liceoatarraya.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {
    private Boolean botonBackPresionado=false;
    private static final int DURACION_SPLASH=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler manejador=new Handler();
        manejador.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                if (!botonBackPresionado) {
                    Intent intento = new Intent(splash.this, Login.class);
                    startActivity(intento);
                }
            }
        },DURACION_SPLASH);
    }
}
