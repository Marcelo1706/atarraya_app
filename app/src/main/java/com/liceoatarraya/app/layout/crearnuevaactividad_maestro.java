package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.liceoatarraya.app.R;

import java.util.Calendar;

public class crearnuevaactividad_maestro extends AppCompatActivity {
    EditText iniciotarea, fintarea;
    Calendar calendario_tareas;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearnuevaactividad_maestro);
        iniciotarea=findViewById(R.id.edt_fechainiciotarea);
        fintarea=findViewById(R.id.edt_fechafinalizaciontarea);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        iniciotarea.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        crearnuevaactividad_maestro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        iniciotarea.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        fintarea.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        crearnuevaactividad_maestro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        fintarea.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
    }
}