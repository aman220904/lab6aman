package com.example.lab6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<ChatMessage> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load your messages here (you can fetch from the database)
        messages = new ArrayList<>();
        messages.add(new ChatMessage("Hello!", System.currentTimeMillis(), 1)); // Sent message
        messages.add(new ChatMessage("Hi!", System.currentTimeMillis(), 0)); // Received message

        adapter = new MyAdapter(messages);
        recyclerView.setAdapter(adapter);
    }
}