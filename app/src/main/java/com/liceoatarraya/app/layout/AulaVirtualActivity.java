package com.liceoatarraya.app.layout;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.liceoatarraya.app.R;
import com.liceoatarraya.app.adapters.SubjectAdapter;
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


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}