package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.liceoatarraya.app.R;

import java.util.ArrayList;

public class reservarEquipos_maestro extends AppCompatActivity {
    private ListView listview;
    private ArrayList<String> names;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_equipos_maestro);
        listview = (ListView) findViewById(R.id.ltv_equiposreservados);
        names = new ArrayList<String>();
        names.add("EQUIPO - RESERVA - FECHA SOLICITADA");
        names.add("Bocinas - JOSE CERRITOS - 01/12/2020");
        names.add("Proyector - DANIEL GARCIA - 07/12/2020");
        names.add("Laptops - JOAQUIN B. - 19/12/2020");
        names.add("Set desarmadores - ANTONIO HERNANDEZ - 22/12/2020");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);
        Button btn = (Button) findViewById(R.id.btn_reservarEquipo);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), reservaEquipo.class);
            startActivityForResult(intent, 0);
        });
    }
}