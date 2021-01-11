package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.liceoatarraya.app.R;

import java.util.Calendar;

public class crearnuevaprueba_maestro extends AppCompatActivity {
    EditText inicioprueba, finprueba;
    Calendar calendario_pruebas;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearnuevaprueba_maestro);
        inicioprueba=findViewById(R.id.edt_fechainicioprueba);
        finprueba=findViewById(R.id.edt_fechafinalizacionprueba);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        inicioprueba.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        crearnuevaprueba_maestro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        inicioprueba.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        finprueba.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        crearnuevaprueba_maestro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        finprueba.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

    }
}