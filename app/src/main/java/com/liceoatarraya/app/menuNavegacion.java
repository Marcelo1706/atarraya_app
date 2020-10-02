package com.liceoatarraya.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.Calendar;

public class menuNavegacion extends AppCompatActivity {
    BottomNavigationView mbottomNavigationView;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_navegacion);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.clases, R.id.calendario, R.id.notas, R.id.mensajes, R.id.notificaciones, R.id.perfil, R.id.menu, R.id.salir)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        /*
        CÓDIGOS PARA MENU INFERIOR
         */
        mbottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //IF PARA CONTROLAR HACIA QUE ACTIVITY ME DEBE ENVIAR AL UTILIZAR EL MENU INFERIOR
                if (item.getItemId() == R.id.menu_aulavirtual) {
                    startActivity(new Intent(getApplicationContext(), aulavirtual_activity.class));
                    overridePendingTransition(0, 0);
                    return true;

                }
                if (item.getItemId() == R.id.menu_calendario) {
                    startActivity(new Intent(getApplicationContext(), calendario_activity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                if (item.getItemId() == R.id.menu_calificaciones) {
                    startActivity(new Intent(getApplicationContext(), calificaciones_activity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navegacion, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //metodo onclick de opcion salir en navigation drawer
    public void onclick(MenuItem item) {
        finish();
    }
}
