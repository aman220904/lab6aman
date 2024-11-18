package com.example.lab6;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id; // Auto-incremented primary key

    @ColumnInfo(name = "message")
    private String message;

    @ColumnInfo(name = "timeSent")
    private long timeSent; // Timestamp for when the message was sent

    @ColumnInfo(name = "sendOrReceive")
    private int sendOrReceive; // 0 = Received, 1 = Sent

    // Constants for message types
    public static final int SENT = 1;
    public static final int RECEIVED = 0;

    // Default constructor (required by Room)
    public ChatMessage() {}

    // Parameterized constructor for convenience
    public ChatMessage(String message, long timeSent, int sendOrReceive) {
        this.message = message;
        this.timeSent = timeSent;
        this.sendOrReceive = sendOrReceive;
    }

    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(long timeSent) {
        this.timeSent = timeSent;
    }

    public int getSendOrReceive() {
        return sendOrReceive;
    }

    public void setSendOrReceive(int sendOrReceive) {
        this.sendOrReceive = sendOrReceive;
    }
}