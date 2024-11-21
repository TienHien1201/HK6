package com.example.gridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class FurnitureAdapterGrid extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Furniture> furnitureList;

    public FurnitureAdapterGrid(Context context, int layout, List<Furniture> furnitureList) {
        this.context = context;
        this.layout = layout;
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
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            view = inflater.inflate(layout, null);
        } else {
            view = convertView;
        }

        ImageView img = view.findViewById(R.id.image);

        // Sử dụng setImageResource để gán ảnh từ drawable ID
        img.setImageResource(furnitureList.get(position).getImageResId());

        return view;
    }

}
