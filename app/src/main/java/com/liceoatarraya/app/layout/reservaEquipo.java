package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.liceoatarraya.app.R;

import java.util.Calendar;

public class reservaEquipo extends AppCompatActivity {
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;
    TextView fechaUsoequipo, fechaDevequipo;
    TextView horaUsoequipo, horaDevequipo;
    DatePickerDialog.OnDateSetListener setListener;
    Calendar calendar;
    TimePickerDialog timePickerDialog;
    int currentHour;
    int currentMinute;
    String amPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_equipo);

        //Texto de ejemplo para el spinner
        Spinner spinner = findViewById(R.id.sp_equiporeserva);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.equipos, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        //Trabajando en seleccionadores de fecha
        fechaUsoequipo = findViewById(R.id.tv_fechaUsoequipo);
        fechaDevequipo = findViewById(R.id.tv_fechaDevequipo);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        fechaUsoequipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        reservaEquipo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        fechaUsoequipo.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        fechaDevequipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        reservaEquipo.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        fechaDevequipo.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        //Trabajando en seleccionadores de Hora
        horaUsoequipo = findViewById(R.id.tv_horaUsoequipo);
        horaDevequipo = findViewById(R.id.tv_horaDevequipo);
        horaUsoequipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(reservaEquipo.this, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(hourOfDay>=12){
                        amPm="PM";
                        }else{
                        amPm="AM";
                         }
                         horaUsoequipo.setText(String.format("%02d:%02d",hourOfDay,minute)+" "+amPm);
                    }
                },currentHour,currentMinute,false);
                timePickerDialog.show();
            }
        });
        horaDevequipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(reservaEquipo.this, new TimePickerDialog.OnTimeSetListener() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                         if(hourOfDay>=12){
                             amPm="PM";
                         }else{
                            amPm="AM";
                         }
                        horaDevequipo.setText(String.format("%02d:%02d",hourOfDay,minute)+" "+amPm);
                    }
                },currentHour,currentMinute,false);
                timePickerDialog.show();
            }
        });
    }
}