package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.liceoatarraya.app.R;

import java.util.ArrayList;

public class planificaciondocente extends AppCompatActivity {
    private ArrayAdapter arrayAdapter;
    private ListView listViewPlanificacion;
    private ArrayList<String> planificaciones;
    private Button subirplanif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificaciondocente);

        //Texto de ejemplo para el list view , para desencadenar el evento onclick
        listViewPlanificacion = (ListView) findViewById(R.id.ltv_plansubidas);
        planificaciones= new ArrayList<String>();
        planificaciones.add("ID - NOMBRE - ASIGNATURA - ARCHIVO");
        planificaciones.add("1 - PLAN CIENCIAS - CIENCIAS_SALUD Y MA - plan2020.pdf");
        planificaciones.add("2 - PLAN SOC - SOCIALES - plan2020sociales.pdf");
        planificaciones.add("3 - ENGLISH PLAN - INGLES - WORKSCHEDULE2020.pdf");
        ArrayAdapter<String> adapteer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planificaciones);
        listViewPlanificacion.setAdapter(adapteer);

        // Boton que me mueva de activity
        subirplanif=findViewById(R.id.btn_subirplanificacion);
        subirplanif.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), subirplanificaciones_maestro.class);
            startActivityForResult(intent, 0);
        });

        //evento que abre el activity para modificar algún contenido
        listViewPlanificacion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), eliminarplanificacion_maestro.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}