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

public class avisos_admin extends AppCompatActivity {
    private ListView listViewavisos_admin;
    private ArrayList<String> avisos_admin;
    private Button crearavis_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos_admin);

        //Texto de ejemplo para el list view , para desencadenar el evento onclick
        listViewavisos_admin = (ListView) findViewById(R.id.ltv_avisos_admin);
        avisos_admin= new ArrayList<String>();
        avisos_admin.add("ID - TITULO - MENSAJE - ESTADO");
        avisos_admin.add("1 - SUSPENCION CLASES - HOY NO HAY CLASES - ACTIVO");
        avisos_admin.add("2 - SUSPENCION CLASES - HOY NO HAY CLASES - DESACTIVADO");
        avisos_admin.add("3 - SUSPENCION CLASES - HOY NO HAY CLASES - ACTIVO");
        ArrayAdapter<String> adapteer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, avisos_admin);
        listViewavisos_admin.setAdapter(adapteer);

        // Boton que me mueva de activity
        crearavis_admin=findViewById(R.id.btn_crearaviso_admin);
        crearavis_admin.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), crearAviso_maestro.class);
            startActivityForResult(intent, 0);
        });
        listViewavisos_admin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), modificaraviso.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}