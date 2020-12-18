package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.liceoatarraya.app.R;

import java.util.ArrayList;

public class rolesdocente_admin extends AppCompatActivity {
    ListView docentesroles;
    ArrayList<String> roles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolesdocente_admin);

        //Texto de ejemplo para el list view , para desencadenar el evento onclick
        docentesroles = (ListView) findViewById(R.id.ltv_docentesroles);
        roles = new ArrayList<String>();
        roles.add("001122334\tMaría Teresa Hamilton");
        roles.add("012345678\tJuan Perez");
        roles.add("029314280\tReynaldo Antonio Molina Velásquez");
        roles.add("039890856\tYuridia Yesenia Marroquin Cuellar");
        roles.add("042008230\tIdania Jeaneth Pineda");
        roles.add("044496984\tKaren Jocabed Sierr");
        roles.add("044674524\tJosue Arturo Cano");
        roles.add("045339012\tMarlon Giovanni Zeceñ");
        ArrayAdapter<String> adapteer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, roles);
        docentesroles.setAdapter(adapteer);

        docentesroles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent (getApplicationContext(), cambiarroldocente.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}