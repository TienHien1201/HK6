package com.example.ecommerceshopping.Fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.OrderDetail;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.adapter.BuyAgainAdapter;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private BuyAgainAdapter buyAgainAdapter;
    private List<String> buyAgainFoodNames = new ArrayList<>();
    private List<String> buyAgainPrices = new ArrayList<>();
    private List<byte[]> buyAgainImages = new ArrayList<byte[]>();

    private DatabaseEcommerceShopingOnline db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);

        // Khởi tạo RecyclerView và adapter
        recyclerView = rootView.findViewById(R.id.BuyAgainRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Khởi tạo database helper
        db = new DatabaseEcommerceShopingOnline(getContext());
        // Lấy dữ liệu từ cơ sở dữ liệu
        loadOrderDetails();

        // Khởi tạo adapter và thiết lập cho RecyclerView
        buyAgainAdapter = new BuyAgainAdapter(buyAgainImages, buyAgainPrices, buyAgainFoodNames);
        recyclerView.setAdapter(buyAgainAdapter);

        return rootView;
    }
    private byte[] drawableToByteArray(int drawableId) {
        BitmapDrawable drawable = (BitmapDrawable) requireContext().getDrawable(drawableId);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
    private void loadOrderDetails() {
        List<OrderDetail> orderDetails = db.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            // Chuyển đổi dữ liệu từ OrderDetail sang dữ liệu cần thiết cho adapter
            buyAgainFoodNames.add(orderDetail.getProductName());
            buyAgainPrices.add("$"+String.valueOf(orderDetail.getTotalPrice()));
            // Giả sử bạn có hình ảnh cho sản phẩm, ví dụ, một danh sách hình ảnh mẫu
            buyAgainImages.add(orderDetail.getImage()); // Thay đổi tùy vào hình ảnh sản phẩm thực tế
        }
    }
}
