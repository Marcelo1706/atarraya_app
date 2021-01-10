package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.cerrarApp;

import java.util.ArrayList;
import java.util.Calendar;

public class menu_maestro extends AppCompatActivity{
    TextView date_in;
    ImageButton date_button;
    DatePickerDialog.OnDateSetListener setListener;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_maestro);
        date_in = findViewById(R.id.tv_fechamenu_maestro);
        date_button = findViewById(R.id.btn_consultarfechamenu_ma);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        menu_maestro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        date_in.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumaestro,menu);
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_maestro:
                Intent intent = new Intent (getApplicationContext(), principal_maestro.class);
                startActivityForResult(intent, 0);
                return  true;
            case R.id.calendario_maestro:
                Intent intent_calendar = new Intent (getApplicationContext(), calendario_maestro.class);
                startActivityForResult(intent_calendar, 0);
                return  true;
            case R.id.aula_virtual_maestro:
                Intent intent3 = new Intent (getApplicationContext(), aulavirtual_maestro.class);
                startActivityForResult(intent3, 0);
                return  true;
            case R.id.menu_maestro:
                return  true;
            case R.id.exit_maestro:
                DialogFragment dialogo=new cerrarApp();
                dialogo.show(getSupportFragmentManager(),"salirapp");
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}