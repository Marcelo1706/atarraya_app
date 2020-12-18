package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.liceoatarraya.app.R;

public class dashad_usuariosroles extends AppCompatActivity implements View.OnClickListener{
    private CardView plantadoc, rolesdoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashad_usuariosroles);
        //Instanciando
        plantadoc=findViewById(R.id.cv_plantadocente);
        rolesdoc=findViewById(R.id.cv_rolesdocente);

        //evento onclick
        plantadoc.setOnClickListener(this);
        rolesdoc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_plant,intent_rol;
        switch (v.getId()){
            case R.id.cv_plantadocente:
                intent_plant = new Intent (this, plantadocente_admin.class);
                startActivityForResult(intent_plant, 0);
                break;
            case R.id.cv_rolesdocente:
                intent_rol= new Intent (this, rolesdocente_admin.class);
                startActivityForResult(intent_rol, 0);
                break;
            default:break;
        }

    }
}