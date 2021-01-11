package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.cerrarApp;

public class dasboard_modAdmin extends AppCompatActivity implements View.OnClickListener {
    private CardView administracionsistema,calendario_agenda,menudiario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard_mod_admin);

        //Instanciando las tarjetas

        administracionsistema=findViewById(R.id.cv_administracion);
        calendario_agenda=findViewById(R.id.cv_calendarioagenda_admin);
        menudiario=findViewById(R.id.cv_menudiario_admin);

        //Agregando Onclick a cada tarjeta

        administracionsistema.setOnClickListener(this);
        calendario_agenda.setOnClickListener(this);
        menudiario.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_modadmin,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.salir_admin:
                DialogFragment dialogo=new cerrarApp();
                dialogo.show(getSupportFragmentManager(),"salirapp");
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent_admin,intent_cal,intent_menu;
        switch (v.getId()){
            case R.id.cv_administracion:
                intent_admin = new Intent (this, dashad_administracion.class);
                startActivityForResult(intent_admin, 0);
                break;
            case R.id.cv_calendarioagenda_admin:
                intent_cal = new Intent (this, calendario_modadmin.class);
                startActivityForResult(intent_cal, 0);
                break;
            case R.id.cv_menudiario_admin:
                intent_menu = new Intent (this, dashboard_comidaAdmin.class);
                startActivityForResult(intent_menu,0);
                break;
            default:break;
        }
    }
}