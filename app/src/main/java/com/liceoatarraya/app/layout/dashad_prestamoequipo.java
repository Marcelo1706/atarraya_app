package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liceoatarraya.app.R;

public class dashad_prestamoequipo extends AppCompatActivity implements View.OnClickListener {
    private CardView registroequipo, reservarequipo, adminreservas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashad_prestamoequipo);

        // Instancia
        registroequipo=findViewById(R.id.cv_registrarequipo);
        reservarequipo=findViewById(R.id.cv_reservarequipo);
        adminreservas=findViewById(R.id.cv_adminreservas);

        //Onclick
        registroequipo.setOnClickListener(this);
        reservarequipo.setOnClickListener(this);
        adminreservas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_registro, intent_reservar, intent_adminreservas;
        switch (v.getId()){
            case R.id.cv_registrarequipo:
                /*intent_registro = new Intent (this, dashad_administracion.class);
                startActivityForResult(intent_registro, 0);*/
                break;
            case R.id.cv_reservarequipo:
                /*intent_reservar = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_reservar, 0);*/
                break;
            case R.id.cv_adminreservas:
                /*intent_adminreservas = new Intent (this, menu_modadmin.class);
                startActivityForResult(intent_adminreservas,0);
                break;*/
            default:break;
        }
    }
}