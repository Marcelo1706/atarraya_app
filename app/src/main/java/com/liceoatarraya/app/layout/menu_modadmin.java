package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.liceoatarraya.app.R;

import java.util.Calendar;

public class menu_modadmin extends AppCompatActivity {
    TextView date_in;
    ImageButton date_button;
    DatePickerDialog.OnDateSetListener setListener;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_modadmin);
        date_in = findViewById(R.id.tv_fechamenu_admin);
        date_button = findViewById(R.id.btn_consultarfechamenu_admin);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        menu_modadmin.this, new DatePickerDialog.OnDateSetListener() {
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
}