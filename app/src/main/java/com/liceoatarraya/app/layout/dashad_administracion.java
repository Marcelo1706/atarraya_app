package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liceoatarraya.app.R;

public class dashad_administracion extends AppCompatActivity implements View.OnClickListener {
    private CardView admingeneral,usuariosroles,registroacademico,reportes,prestamo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashad_administracion);

        //Instanciando las tarjetas

        admingeneral=findViewById(R.id.cv_admingeneral);
        usuariosroles=findViewById(R.id.cv_usuariosyroles);
        registroacademico=findViewById(R.id.cv_registroacademico);
        reportes=findViewById(R.id.cv_reportesadmin);
        prestamo=findViewById(R.id.cv_prestamoequipo_admin);

        //Agregando Onclick a cada tarjeta

        admingeneral.setOnClickListener(this);
        usuariosroles.setOnClickListener(this);
        registroacademico.setOnClickListener(this);
        reportes.setOnClickListener(this);
        prestamo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_adming,intent_usu,intent_reg, intent_rep, intent_prest;
        switch (v.getId()){
            case R.id.cv_admingeneral:
                /*intent_adming = new Intent (this, dashad_administracion.class);
                startActivityForResult(intent_adming, 0);*/
                break;
            case R.id.cv_usuariosyroles:
                /*intent_usu = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_usu, 0);*/
                break;
            case R.id.cv_registroacademico:
                intent_reg = new Intent (this, dashad_registroacademico.class);
                startActivityForResult(intent_reg,0);
                break;
            case R.id.cv_reportesadmin:
                /*intent_rep = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_rep, 0);*/
            break;
            case R.id.cv_prestamoequipo_admin:
                /*intent_prest = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_prest, 0);*/
                break;
            default:break;
        }
    }
}