package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.liceoatarraya.app.R;

import java.util.ArrayList;
import java.util.Calendar;

public class controlasistencia_maestro extends AppCompatActivity {
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;
    private ListView listView;
    private ArrayList<String> asistencia;
    private TextView controlA;
    DatePickerDialog.OnDateSetListener setListener;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlasistencia_maestro);

        //Texto de ejemplo para el spinner
        Spinner spinner = findViewById(R.id.sp_gradoconsulta);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.gradosasistencia_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        //Texto de ejemplo para el list view , para desencadenar el evento onclick
        listView = (ListView) findViewById(R.id.ltv_asistenciaalumnos);
        asistencia = new ArrayList<String>();
        asistencia.add("Diego Maradona");
        asistencia.add("Pedro Infante");
        asistencia.add("Chadwick Bosseman");
        asistencia.add("Kurt Cobain");
        asistencia.add("Stan Lee");
        asistencia.add("Diego Maradona 2");
        asistencia.add("Pedro Infante 2");
        asistencia.add("Chadwick Bosseman 2");
        asistencia.add("Kurt Cobain 2");
        asistencia.add("Stan Lee 2");
        ArrayAdapter<String> adapteer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, asistencia);
        listView.setAdapter(adapteer);

        //Trabajando en el botón que me permita seleccionar la fecha y luego de alli me muestre la lista
        controlA=findViewById(R.id.tv_fechaconsultarasistencia);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        controlA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        controlasistencia_maestro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date = day+"/"+month+"/"+year;
                        controlA.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), reporteAsistencia.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}