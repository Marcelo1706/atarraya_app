package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Intent intent;
        switch (v.getId()){
            case R.id.cv_adminalumnos:
                /*intent = new Intent (this, dashad_administracion.class);
                startActivityForResult(intent, 0);*/
                break;
            case R.id.cv_admingradossecc:
                intent = new Intent (this, GradosSeccionesActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.cv_adminasignaturas:
                intent = new Intent (this, SubjectManagementActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_promgrados:
                Toast.makeText(getApplicationContext(), "Esta función aún no está disponible, pero lo estará en un futuro", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cv_ponderaasignatura:
                intent = new Intent (this, PonderacionAsignaturasActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.cv_periodosasig:
                intent = new Intent (this, PeriodosMateriasActivity.class);
                startActivityForResult(intent, 0);
                break;
            default:break;
        }
    }
}