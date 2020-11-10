package com.liceoatarraya.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowInsets;
import android.view.WindowManager;

import java.util.Objects;

public class splash extends AppCompatActivity {
    private Boolean botonBackPresionado=false;
    private static final int DURACION_SPLASH=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Mostrar el activity en pantalla completa
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            Objects.requireNonNull(getWindow().getInsetsController()).hide(WindowInsets.Type.statusBars());
        }else{
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        }
        //Ocultar barra de título
        Objects.requireNonNull(getSupportActionBar()).hide();
        
        Handler manejador=new Handler(Looper.getMainLooper());
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
