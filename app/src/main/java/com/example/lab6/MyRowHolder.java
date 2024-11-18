package com.example.lab6;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyRowHolder extends RecyclerView.ViewHolder {
    TextView messageText;
    TextView timeText;
    private MyAdapter adapter;

    public MyRowHolder(View itemView, MyAdapter adapter) {
        super(itemView);
        this.adapter = adapter;  // Store the adapter reference

        messageText = itemView.findViewById(R.id.messageText);
        timeText = itemView.findViewById(R.id.timeText);

        // Set click listener for each row item
        itemView.setOnClickListener(clk -> {
            int position = getBindingAdapterPosition(); // Get the position of the clicked item
            if (position == RecyclerView.NO_POSITION) return;

            // Create an alert dialog to confirm deletion
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setTitle("Delete Message")
                    .setMessage("Are you sure you want to delete this message?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // Access the adapter to get the item
                        ChatMessage messageToDelete = adapter.getMessages().get(position);

                        // Use an Executor to handle the background deletion operation
                        Executor thread = Executors.newSingleThreadExecutor();
                        thread.execute(() -> {
                            // Access the DAO and delete the message from the database
                            ChatMessageDAO mDAO = MessageDatabase.getInstance(itemView.getContext()).cmDAO();
                            mDAO.deleteMessage(messageToDelete);

                            // Post back to the UI thread to remove the item from the RecyclerView
                            itemView.post(() -> adapter.removeItem(position));
                        });
                    })
                    .setNegativeButton("No", null) // Do nothing on "No"
                    .create()
                    .show();
        });
    }
}