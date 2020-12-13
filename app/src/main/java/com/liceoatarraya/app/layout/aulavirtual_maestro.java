package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.liceoatarraya.app.R;

public class aulavirtual_maestro extends AppCompatActivity implements View.OnClickListener {
    private CardView clases,reportes,asistencia,trabajodocente,prestamoequipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aulavirtual_maestro);
        //Instanciando las tarjetas
        clases=findViewById(R.id.cv_clases);
        reportes=findViewById(R.id.cv_reportes);
        asistencia=findViewById(R.id.cv_asistencia);
        trabajodocente=findViewById(R.id.cv_trabajodocente);
        prestamoequipo=findViewById(R.id.cv_prestamoequipo);
        //Agregando Onclick a cada tarjeta
        clases.setOnClickListener(this);
        reportes.setOnClickListener(this);
        asistencia.setOnClickListener(this);
        trabajodocente.setOnClickListener(this);
        prestamoequipo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_a1,intent_a2,intent_a3,intent_a4,intent_a5;
        switch (v.getId()){
            case R.id.cv_clases:
                intent_a1 = new Intent (this, dashboard_clases.class);
                startActivityForResult(intent_a1, 0);
                break;
            case R.id.cv_reportes:
                intent_a2 = new Intent (this, reportes_maestro.class);
                startActivityForResult(intent_a2, 0);
                break;
            case R.id.cv_asistencia:
                intent_a4 = new Intent (this, controlasistencia_maestro.class);
                startActivityForResult(intent_a4,0);
                break;
            case R.id.cv_trabajodocente:
                intent_a5 = new Intent (this, planificaciondocente.class);
                startActivityForResult(intent_a5,0);
                break;
            case R.id.cv_prestamoequipo:
                intent_a3 = new Intent (this, reservarEquipos_maestro.class);
                startActivityForResult(intent_a3,0);
                break;
            default:break;

        }

    }
}