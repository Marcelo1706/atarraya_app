package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liceoatarraya.app.R;

import java.util.ArrayList;
import java.util.List;

public class GradosSeccionesActivity extends AppCompatActivity {

    ListView lvGrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grados_secciones);

        List<String> grados = new ArrayList<>();
        grados.add("Primero");
        grados.add("Segundo");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, grados);
        lvGrados = findViewById(R.id.lvGrado);

        lvGrados.setAdapter(adapter);

        registerForContextMenu(lvGrados);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_grados_secciones, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        switch (item.getItemId()) {
            case R.id.editarGrado:
                Intent intent = new Intent(getApplicationContext(), EditarGradoActivity.class);
                startActivity(intent);
                return true;
            case R.id.desactivarGrado:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void launchOrientadoresActivity(View v){
        Intent intent = new Intent(getApplicationContext(), OrientadoresActivity.class);
        startActivity(intent);
    }

    public void launchAgregarGradoActivity(View v){
        Intent intent = new Intent(getApplicationContext(), EditarGradoActivity.class);
        startActivity(intent);
    }
}