package com.liceoatarraya.app;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class menuNavegacion extends AppCompatActivity {
    EditText date_in;
    BottomNavigationView mbottomNavigationView;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*DESCOMENTAR ESTA PARTE PARA REVISAR EL ERROR DEL DATEPICKER
        //Cod para el datepicker del menu
        date_in=findViewById(R.id.date_input);
        date_in.setInputType(InputType.TYPE_NULL);

        date_in.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });
        //Fin del Cod para el datepicker
         */

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
    /*METODO DEL DATEPICKER
    private void showDateDialog(final EditText date_in) {
        final Calendar calendar= Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yy");
                date_in.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new DatePickerDialog(menuNavegacion.this,dateSetListener,calendar.get(calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

    }
    */
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
