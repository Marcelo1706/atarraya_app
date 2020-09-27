package com.liceoatarraya.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class aulavirtual_activity extends AppCompatActivity {
BottomNavigationView avbottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aulavirtual_activity);
        avbottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv_aulavirtual);
        avbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
            }
        });
    }
}