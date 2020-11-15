package com.liceoatarraya.app.layout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.liceoatarraya.app.R;

import java.util.Calendar;

public class agregarEventos extends AppCompatActivity {
    EditText etDateS, etDateF;
    EditText etTimeS, etTimeF;
    DatePickerDialog.OnDateSetListener setListener;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_eventos);
        etDateS=findViewById(R.id.edt_fechadesde);
        etDateF=findViewById(R.id.edt_fechahasta);
        etTimeS=findViewById(R.id.edt_horainicio);
        etTimeF=findViewById(R.id.edt_horafinal);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        etDateS.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        agregarEventos.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        etDateS.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        etDateF.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        agregarEventos.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        etDateF.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        etTimeS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calendar calendar= Calendar.getInstance();
                //currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                //currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(agregarEventos.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                       // if(hourOfDay>=12){
                       //     amPm="PM";
                      //  }else{
                      //      amPm="AM";
                      //  }
                      //  etTimeS.setText(String.format("%02d:%02d",hourOfDay,minute)+amPm);
                        etTimeS.setText(hourOfDay+":"+minute);
                    }
                },currentHour,currentMinute,false);
                timePickerDialog.show();
            }
        });
        etTimeF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calendar calendar= Calendar.getInstance();
                //currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                //currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(agregarEventos.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // if(hourOfDay>=12){
                        //     amPm="PM";
                        //  }else{
                        //      amPm="AM";
                        //  }
                        //  etTimeS.setText(String.format("%02d:%02d",hourOfDay,minute)+amPm);
                        etTimeF.setText(hourOfDay+":"+minute);
                    }
                },currentHour,currentMinute,false);
                timePickerDialog.show();
            }
        });
    }
}