package com.example.lab6;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ChatMessage.class}, version = 1, exportSchema = false)
public abstract class MessageDatabase extends RoomDatabase {

    // Define the DAO for accessing ChatMessage entities
    public abstract ChatMessageDAO cmDAO();

    private static volatile MessageDatabase INSTANCE;

    // Singleton pattern for MessageDatabase
    public static MessageDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MessageDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MessageDatabase.class, "message_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}