package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    Context myContext;
    int myLayout;
    List<SinhVien> mangSinhVien;

    public SinhVienAdapter(Context myContext, int myLayout, List<SinhVien> mangSinhVien) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.mangSinhVien = mangSinhVien;
    }

    @Override
    public int getCount() {
        return mangSinhVien.size();
    }

    @Override
    public Object getItem(int i) {
        return mangSinhVien.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout, null);

        // Tham chiếu và gán giá trị
        TextView tvTen = convertView.findViewById(R.id.tvTen);
        TextView tvTuoi = convertView.findViewById(R.id.tvTuoi);
        ImageView imgSinhVien = convertView.findViewById(R.id.imgSinhVien);

        // Gán dữ liệu cho các view
        SinhVien sinhVien = mangSinhVien.get(position);
        tvTen.setText(sinhVien.getTen());
        tvTuoi.setText(String.valueOf(sinhVien.getTuoi()));
        imgSinhVien.setImageResource(sinhVien.getAnh()); // Gán ảnh vào ImageView

        return convertView;
    }
}
