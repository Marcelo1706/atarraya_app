package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liceoatarraya.app.R;

public class dashboard_comidaAdmin extends AppCompatActivity implements View.OnClickListener {
    private CardView crearmenu, consultarmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_comida_admin);
        crearmenu =findViewById(R.id.cv_agregarmenu);
        consultarmenu=findViewById(R.id.cv_consultarmenu);

        //evento onclick
        crearmenu.setOnClickListener(this);
        consultarmenu.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent_agregar,intent_consultar;
        switch (v.getId()){
            case R.id.cv_agregarmenu:
                intent_agregar= new Intent (this, agregarmenu_admin.class);
                startActivityForResult(intent_agregar, 0);
                break;
            case R.id.cv_consultarmenu:
                intent_consultar= new Intent (this, menu_modadmin.class);
                startActivityForResult(intent_consultar, 0);
                break;
            default:break;
        }

    }
}