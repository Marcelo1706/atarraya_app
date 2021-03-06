package com.liceoatarraya.app.layout;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liceoatarraya.app.R;

public class calificaciones_activity extends AppCompatActivity {
BottomNavigationView calibottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calificaciones_activity);
        setTitle("Calificaciones");
        calibottomNavigationView= findViewById(R.id.bnv_calificaciones);
        calibottomNavigationView.setSelectedItemId(R.id.menu_calificaciones);
        calibottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.menu_home){
                startActivity(new Intent(getApplicationContext(),menuNavegacion.class));
                overridePendingTransition(0,0 );
                return true;
            }
            if(item.getItemId()==R.id.menu_aulavirtual){
                startActivity(new Intent(getApplicationContext(),aulavirtual_activity.class));
                overridePendingTransition(0,0 );
                return true;
            }
            if(item.getItemId()==R.id.menu_calendario){
                startActivity(new Intent(getApplicationContext(),calendario_activity.class));
                overridePendingTransition(0,0 );
                return true;
            }

            return true;
        });
    }
}