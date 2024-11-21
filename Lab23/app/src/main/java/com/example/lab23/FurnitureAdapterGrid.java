package com.example.lab23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.List;

public class FurnitureAdapterGrid extends BaseAdapter {

    private Context context;
    private List<Categories> categoriesList; // Danh sách các Category
    private OnItemClickListener onItemClickListener;

    // Interface cho sự kiện click
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Set listener để xử lý click item
    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public FurnitureAdapterGrid(Context context, List<Categories> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoriesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // Inflate layout cho item của GridView
            convertView = LayoutInflater.from(context).inflate(R.layout.item_furniture_grid, parent, false);
        }

        // Get item category hiện tại
        Categories category = categoriesList.get(position);

        // Bind data vào các view
        TextView nameTextView = convertView.findViewById(R.id.furniture_name);
        ImageView imageView = convertView.findViewById(R.id.furniture_image);

        nameTextView.setText(category.getName());
        imageView.setImageResource(category.getImage());

        // Set click listener cho item
        convertView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position); // Gọi hàm onItemClick trong DashboardFragment
            }
        });

        return convertView;
    }
}
