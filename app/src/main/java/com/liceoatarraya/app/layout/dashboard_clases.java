package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.liceoatarraya.app.R;

public class dashboard_clases extends AppCompatActivity implements View.OnClickListener {
    private CardView admincont,vercont,adminavisos,adminpruebas,adminactividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_clases);

        //Instanciando las tarjetas

        admincont=findViewById(R.id.cv_admincontenidoclase);
        vercont=findViewById(R.id.cv_vercontenido);
        adminavisos=findViewById(R.id.cv_avisosmateria);
        adminpruebas=findViewById(R.id.cv_adminpruebas);
        adminactividades=findViewById(R.id.cv_adminactividades);

        //Agregando Onclick a cada tarjeta

        admincont.setOnClickListener(this);
        vercont.setOnClickListener(this);
        adminavisos.setOnClickListener(this);
        adminpruebas.setOnClickListener(this);
        adminactividades.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intenta1,intenta2,intenta3,intenta4,intenta5;
        switch (v.getId()){
            case R.id.cv_admincontenidoclase:
                intenta1 = new Intent (this, dashboard_clases.class);
                startActivityForResult(intenta1, 0);
                break;
            case R.id.cv_vercontenido:
                intenta2 = new Intent (this, reportes_maestro.class);
                startActivityForResult(intenta2, 0);
                break;
            case R.id.cv_avisosmateria:
                intenta3 = new Intent (this, avisosMateria_maestro.class);
                startActivityForResult(intenta3,0);
                break;
            case R.id.cv_adminpruebas:
                break;
            case R.id.cv_adminactividades:
                intenta5 = new Intent (this, reservarEquipos_maestro.class);
                startActivityForResult(intenta5,0);
                break;
            default:break;

        }
    }
}