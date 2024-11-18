package com.example.lab6;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChatMessageDAO {
    // Insert a new ChatMessage into the database and return the newly created ID
    @Insert
    public long insert(ChatMessage newMessage);

    // Retrieve all ChatMessage objects from the database
    @Query("SELECT * FROM ChatMessage")
    public List<ChatMessage> getAllMessages();

    // Delete a specific ChatMessage from the database
    @Delete
    public void deleteMessage(ChatMessage m);
}