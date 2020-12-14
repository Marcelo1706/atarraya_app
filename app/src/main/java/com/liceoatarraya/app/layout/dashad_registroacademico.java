package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liceoatarraya.app.R;

public class dashad_registroacademico extends AppCompatActivity implements View.OnClickListener {
    private CardView adminalumnos, admingradossecc, adminasigna, promgrados, ponderacionasig,periodoasig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashad_registroacademico);

        //Instanciando las tarjetas

        adminalumnos=findViewById(R.id.cv_adminalumnos);
        admingradossecc=findViewById(R.id.cv_admingradossecc);
        adminasigna=findViewById(R.id.cv_adminasignaturas);
        promgrados=findViewById(R.id.cv_promgrados);
        ponderacionasig=findViewById(R.id.cv_ponderaasignatura);
        periodoasig=findViewById(R.id.cv_periodosasig);

        //Agregando Onclick a cada tarjeta

        adminalumnos.setOnClickListener(this);
        admingradossecc.setOnClickListener(this);
        adminasigna.setOnClickListener(this);
        promgrados.setOnClickListener(this);
        ponderacionasig.setOnClickListener(this);
        periodoasig.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_adminalum,intent_admingrad,intent_adminasig, intent_prom, intent_ponder,intent_perio;
        switch (v.getId()){
            case R.id.cv_adminalumnos:
                /*intent_adminalum = new Intent (this, dashad_administracion.class);
                startActivityForResult(intent_adminalum, 0);*/
                break;
            case R.id.cv_admingradossecc:
                /*intent_admingrad = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_admingrad, 0);*/
                break;
            case R.id.cv_adminasignaturas:
                /*intent_adminasig = new Intent (this, menu_modadmin.class);
                startActivityForResult(intent_adminasig,0);
                break;*/
            case R.id.cv_promgrados:
                /*intent_prom= new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_prom, 0);*/
                break;
            case R.id.cv_ponderaasignatura:
                /*intent_ponder = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_ponder, 0);*/
                break;
            case R.id.cv_periodosasig:
                /*intent_perio = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_perio, 0);*/
                break;
            default:break;
        }
    }
}