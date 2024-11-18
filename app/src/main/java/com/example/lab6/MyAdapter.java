package com.example.lab6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyRowHolder> {
    private List<ChatMessage> messages;

    @Override
    public int getItemViewType(int position) {
        // Determine the type of layout based on the message type
        ChatMessage message = messages.get(position);
        return message.getSendOrReceive(); // 0 = Received, 1 = Sent
    }

    @NonNull
    @Override
    public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the correct layout based on the message type (sent or received)
        View view;
        if (viewType == ChatMessage.SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_layout_sent, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_layout_received, parent, false);
        }

        return new MyRowHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
        ChatMessage currentMessage = messages.get(position);
        holder.messageText.setText(currentMessage.getMessage());

        // Format the timestamp into a readable time (optional, depending on your needs)
        String formattedTime = String.valueOf(currentMessage.getTimeSent());
        holder.timeText.setText(formattedTime);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    // Method to remove an item from the list and notify the adapter
    public void removeItem(int position) {
        messages.remove(position);
        notifyItemRemoved(position);
    }

    // Method to add a new message and notify the adapter
    public void addItem(ChatMessage message) {
        messages.add(message);
        notifyItemInserted(messages.size() - 1);
    }

    // Optionally override this method if you have different layouts for different message types
}