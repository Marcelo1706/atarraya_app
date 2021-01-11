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

public class contenidos_maestro extends AppCompatActivity {
    private Spinner spinner_contenido;
    private ListView listView_contenido;
    private ArrayAdapter contenido;
    private ArrayList<String> contenido_array;
    private Button agregarcont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenidos_maestro);

        //Texto de ejemplo para el spinner
        Spinner spinner_contenido = findViewById(R.id.sp_materiacontenido);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_materias, android.R.layout.simple_spinner_item);
        spinner_contenido.setAdapter(adapter);

        //Texto de ejemplo para el list view ,
        listView_contenido= (ListView) findViewById(R.id.ltv_materialmaestro);
        contenido_array = new ArrayList<String>();
        contenido_array.add("Prueba a");
        contenido_array.add("Prueba b");
        contenido_array.add("Sección #1");
        contenido_array.add("QUINTA SECCIÓN");
        ArrayAdapter<String> adapter_contenido = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contenido_array);
        listView_contenido.setAdapter(adapter_contenido);

        // Boton que me mueva de activity
        agregarcont=findViewById(R.id.btn_agregarcontenido);
        agregarcont.setOnClickListener(v -> {
            Intent intent = new Intent (v.getContext(), agregar_modif_contenido.class);
            startActivityForResult(intent, 0);
        });

        //evento que abre el activity para modificar algún contenido
        listView_contenido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), eliminarcontenido_maestro.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}