package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.liceoatarraya.app.R;

public class PeriodosMateriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodos_materias);
        setTitle(getString(R.string.periodos_asignatura));
        WebView wvReport = findViewById(R.id.wbPeriodos);

        wvReport.loadUrl("https://stackoverflow.com//");

    }
}