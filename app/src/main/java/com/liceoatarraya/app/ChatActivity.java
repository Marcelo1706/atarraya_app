package com.liceoatarraya.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.liceoatarraya.app.adapters.ConversationAdapter;
import com.liceoatarraya.app.models.ConversationSingleton;

import java.util.Objects;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ListView chat = findViewById(R.id.lwChat);
        ConversationSingleton conversation = ConversationSingleton.getInstance();
        ConversationAdapter adapter = new ConversationAdapter(this, conversation.getMessages());
        chat.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}