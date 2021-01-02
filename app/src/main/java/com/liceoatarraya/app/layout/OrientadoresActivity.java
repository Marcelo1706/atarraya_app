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

public class OrientadoresActivity extends AppCompatActivity {

    ListView lvOrientadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientadores);

        List<String> orientadores = new ArrayList<>();
        orientadores.add("Primero");
        orientadores.add("Segundo");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orientadores);
        lvOrientadores = findViewById(R.id.lvOrientadores);

        lvOrientadores.setAdapter(adapter);

        registerForContextMenu(lvOrientadores);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_orientadores, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        switch (item.getItemId()) {
            case R.id.editarOrientador:
                Intent intent = new Intent(getApplicationContext(), EditarOrientadorActivity.class);
                startActivity(intent);
                return true;
            case R.id.dropOrientador:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void createOrientador(View v){
        Intent intent = new Intent(getApplicationContext(), EditarOrientadorActivity.class);
        startActivity(intent);
    }
}