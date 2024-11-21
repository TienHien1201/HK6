package com.example.ecommerceshopping.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ecommerceshopping.databinding.NotificationItemBinding;
import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {
    private ArrayList<String> notifications;
    private ArrayList<Integer> notificationImages;

    public NotificationAdapter(ArrayList<String> notifications, ArrayList<Integer> notificationImages) {
        this.notifications = notifications;
        this.notificationImages = notificationImages;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NotificationItemBinding binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NotificationHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        String text = notifications.get(position);
        int imageRes = notificationImages.get(position);
        holder.bind(text, imageRes);
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static class NotificationHolder extends RecyclerView.ViewHolder {
        private final NotificationItemBinding binding;

        public NotificationHolder(@NonNull NotificationItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String text, int imageRes) {
            binding.notificationTextView.setText(text);
            binding.notificationImageView.setImageResource(imageRes);
        }
    }
}
