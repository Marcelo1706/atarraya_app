package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.liceoatarraya.app.R;

public class PonderacionAsignaturasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ponderacion_asignaturas);
        setTitle(getString(R.string.ponderacion_asignaturas));
        WebView wbPonderacion = findViewById(R.id.wbPonderacion);

        wbPonderacion.loadUrl("https://stackoverflow.com//");
    }
}