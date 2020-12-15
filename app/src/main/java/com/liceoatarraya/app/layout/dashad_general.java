package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liceoatarraya.app.R;

public class dashad_general extends AppCompatActivity implements View.OnClickListener {
    private CardView datosinst, devocionales, avisosadmin,versiculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashad_general);

        //Instanciando cada tarjeta
        datosinst=findViewById(R.id.cv_datosinstitucion);
        devocionales=findViewById(R.id.cv_devocionales);
        avisosadmin=findViewById(R.id.cv_avisosadmin);
        versiculo=findViewById(R.id.cv_versiculos);

        //agregando Onclick a cada tarjeta
        datosinst.setOnClickListener(this);
        devocionales.setOnClickListener(this);
        avisosadmin.setOnClickListener(this);
        versiculo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_datos,intent_devo,intent_avisos, intent_versi;
        switch (v.getId()){
            case R.id.cv_datosinstitucion:
                intent_datos= new Intent (this, datosinstitucion_admin.class);
                startActivityForResult(intent_datos, 0);
                break;
            case R.id.cv_devocionales:
                intent_devo = new Intent (this, devocionales_admin.class);
                startActivityForResult(intent_devo, 0);
                break;
            case R.id.cv_avisosadmin:
                intent_avisos = new Intent (this, avisos_admin.class);
                startActivityForResult(intent_avisos,0);
                break;
            case R.id.cv_versiculos:
                intent_versi= new Intent (this, versiculo_admin.class);
                startActivityForResult(intent_versi, 0);
                break;
            default:break;
        }
    }
}