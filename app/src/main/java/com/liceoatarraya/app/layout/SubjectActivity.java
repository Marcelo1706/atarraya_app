package com.liceoatarraya.app.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.liceoatarraya.app.R;

public class SubjectActivity extends AppCompatActivity {

    TextView tvSubjectTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");
        String position = intent.getStringExtra("POSITION");
        String description = intent.getStringExtra("DESCRIPTION");

        tvSubjectTitle = findViewById(R.id.tvSubjectTitle);
        tvSubjectTitle.setText(String.format("%s - %s", id, description));
    }
}