package com.liceoatarraya.app.layout;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liceoatarraya.app.R;

public class aulavirtual_activity extends AppCompatActivity {
BottomNavigationView avbottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aulavirtual_activity);
        setTitle("Aula virtual");
        avbottomNavigationView= findViewById(R.id.bnv_aulavirtual);
        avbottomNavigationView.setSelectedItemId(R.id.menu_aulavirtual);
        avbottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.menu_home){
                startActivity(new Intent(getApplicationContext(),menuNavegacion.class));
                overridePendingTransition(0,0);
                return true;
            }
            if(item.getItemId()==R.id.menu_calificaciones){
                startActivity(new Intent(getApplicationContext(),calificaciones_activity.class));
                overridePendingTransition(0,0);
                return true;
            }
            if(item.getItemId()==R.id.menu_calendario){
                startActivity(new Intent(getApplicationContext(),calendario_activity.class));
                overridePendingTransition(0,0);
                return true;
            }
            return true;
        });
    }
}