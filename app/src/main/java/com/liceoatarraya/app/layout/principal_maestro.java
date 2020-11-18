package com.liceoatarraya.app.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_maestro:
                info.setText("Se eligio la opción inicio");
            return  true;
            case R.id.calendario_maestro:
                info.setText("Se eligio la opción calendario maestro");
            return  true;
            case R.id.aula_virtual_maestro:
                info.setText("Se eligio la opción aula virtual maestro");
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