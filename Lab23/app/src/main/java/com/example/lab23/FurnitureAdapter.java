package com.example.lab23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.List;

public class FurnitureAdapter extends BaseAdapter {

    private final Context context;
    private final List<Furniture> furnitureList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Set the listener to handle clicks
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public FurnitureAdapter(Context context, List<Furniture> furnitureList) {
        this.context = context;
        this.furnitureList = furnitureList;
    }

    @Override
    public int getCount() {
        return furnitureList.size();
    }

    @Override
    public Object getItem(int position) {
        return furnitureList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Inflate layout for item
            convertView = LayoutInflater.from(context).inflate(R.layout.item_furniture_list, parent, false);
        }

        // Get current furniture item
        Furniture furniture = furnitureList.get(position);

        // Bind data to views
        TextView nameTextView = convertView.findViewById(R.id.furniture_name);
        TextView descriptionTextView = convertView.findViewById(R.id.furniture_description);
        ImageView imageView = convertView.findViewById(R.id.furniture_image);

        nameTextView.setText(furniture.getName());
        descriptionTextView.setText(furniture.getDescription());
        imageView.setImageResource(furniture.getImage());

        // Set click listener
        convertView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });

        return convertView;
    }
}
