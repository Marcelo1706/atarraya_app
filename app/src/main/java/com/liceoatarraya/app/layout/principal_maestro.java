package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.cerrarApp;

public class principal_maestro extends AppCompatActivity {
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_maestro);
        //Obteniendo la instancia del textview
        info=(TextView)findViewById(R.id.tv_versiculo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumaestro,menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_maestro:
            return  true;
            case R.id.calendario_maestro:
                Intent intent = new Intent (getApplicationContext(), calendario_maestro.class);
                startActivityForResult(intent, 0);
            return  true;
            case R.id.aula_virtual_maestro:
                Intent intent3 = new Intent (getApplicationContext(), aulavirtual_maestro.class);
                startActivityForResult(intent3, 0);
            return  true;
            case R.id.menu_maestro:
                Intent intent2 = new Intent (getApplicationContext(), menu_maestro.class);
                startActivityForResult(intent2, 0);
                return  true;
            case R.id.exit_maestro:
                DialogFragment dialogo=new cerrarApp();
                dialogo.show(getSupportFragmentManager(),"salirapp");
            return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}