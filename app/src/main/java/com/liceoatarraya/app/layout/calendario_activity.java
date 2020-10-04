package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liceoatarraya.app.R;

public class calendario_activity extends AppCompatActivity {
 BottomNavigationView calbottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario_activity);
        setTitle("Calendario");
        calbottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv_calendario);
        calbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //IF PARA CONTROLAR HACIA QUE ACTIVITY ME DEBE ENVIAR AL UTILIZAR EL MENU INFERIOR
                if (item.getItemId()==R.id.menu_aulavirtual){
                    startActivity(new Intent(getApplicationContext(), aulavirtual_activity.class));
                    overridePendingTransition(0,0);
                    return  true;

                }
                if (item.getItemId()==R.id.menu_home){
                    startActivity(new Intent(getApplicationContext(), menuNavegacion.class));
                    overridePendingTransition(0,0);
                    return  true;
                }
                if (item.getItemId()==R.id.menu_calificaciones){
                    startActivity(new Intent(getApplicationContext(), calificaciones_activity.class));
                    overridePendingTransition(0,0);
                    return  true;
                }
                return true;
            }
        });
    }
}