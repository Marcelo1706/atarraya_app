package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.liceoatarraya.app.R;

public class Login extends AppCompatActivity {
    EditText usuario;
    EditText contra;
    Spinner rol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("");
        usuario=(EditText)findViewById(R.id.editTextTextPersonName);
        contra = (EditText) findViewById(R.id.editTextTextPersonName2);
        rol = (Spinner) findViewById(R.id.spiner_rol);
        String []opciones={"maestro","alumno","administrativo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        rol.setAdapter(adapter);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarsegunrol();
            }
        });
    }
    private void lanzarsegunrol() {
        usuario=(EditText)findViewById(R.id.editTextTextPersonName);
        contra = (EditText) findViewById(R.id.editTextTextPersonName2);
        rol = (Spinner) findViewById(R.id.spiner_rol);
        int position = (Integer) rol.getSelectedItemPosition();
        if (position==0){
            Intent intent = new Intent (getApplicationContext(), aulavirtual_activity.class);
            startActivityForResult(intent, 0);
        }else
        if (position==1){
            Intent intent = new Intent (getApplicationContext(), menuNavegacion.class);
            startActivityForResult(intent, 0);
        }else
        if (position==2){
            Intent intent = new Intent (getApplicationContext(), calificaciones_activity.class);
            startActivityForResult(intent, 0);
        }
    }
}