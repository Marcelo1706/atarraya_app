package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.liceoatarraya.app.R;

import java.util.ArrayList;

public class avisosMateria_maestro extends AppCompatActivity {
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;
    private ListView listViewavisos;
    private ArrayList<String> avisos;
    private Button crearaviso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos_materia_maestro);
        //Texto de ejemplo para el spinner
        Spinner spinner = findViewById(R.id.sp_materia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_materias, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        //Texto de ejemplo para el list view , para desencadenar el evento onclick
        listViewavisos = (ListView) findViewById(R.id.ltv_avisosmateria);
        avisos= new ArrayList<String>();
        avisos.add("ID - TITULO - MENSAJE - ESTADO");
        avisos.add("1 - SUSPENCION CLASES - HOY NO HAY CLASES - ACTIVO");
        avisos.add("2 - SUSPENCION CLASES - HOY NO HAY CLASES - DESACTIVADO");
        avisos.add("3 - SUSPENCION CLASES - HOY NO HAY CLASES - ACTIVO");
        ArrayAdapter<String> adapteer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, avisos);
        listViewavisos.setAdapter(adapteer);

        // Boton que me mueva de activity
        crearaviso=findViewById(R.id.btn_crearaviso);
        crearaviso.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), crearAviso_maestro.class);
            startActivityForResult(intent, 0);
        });
        listViewavisos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), modificaraviso.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}