package com.liceoatarraya.app.layout;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.adapters.SubjectAdapter;
import com.liceoatarraya.app.models.SubjectModel;
import com.liceoatarraya.app.models.SubjectSingleton;

import java.util.Objects;

public class AulaVirtualActivity extends AppCompatActivity {

    ListView lvSubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_virtual);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        lvSubjects = findViewById(R.id.lvSubjects);
        SubjectSingleton subject = SubjectSingleton.getInstance();
        SubjectAdapter adapter = new SubjectAdapter(this, subject.getSubjects());
        lvSubjects.setAdapter(adapter);

        lvSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SubjectActivity.class);
                SubjectModel model = (SubjectModel)lvSubjects.getItemAtPosition(position);
                intent.putExtra("ID", model.getId());
                intent.putExtra("POSITION", String.valueOf(position));
                intent.putExtra("DESCRIPTION", model.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}