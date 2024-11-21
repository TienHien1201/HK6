package com.example.ecommerceshopping.Fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.MenuItem;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.adapter.MenuAdapter;
import com.example.ecommerceshopping.databinding.FragmentMenuBootomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MenuBootomSheetFragment extends BottomSheetDialogFragment {
    private FragmentMenuBootomSheetBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMenuBootomSheetBinding.inflate(inflater, container, false);

        binding.buttonBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        DatabaseEcommerceShopingOnline db = new DatabaseEcommerceShopingOnline(requireContext());

        if (db.getMenuItems().isEmpty()) {
            db.insertMenuItem("Burger", 5, drawableToByteArray(R.drawable.menu1));
            db.insertMenuItem("Sandwich", 7, drawableToByteArray(R.drawable.menu2));
            db.insertMenuItem("Momo", 8, drawableToByteArray(R.drawable.menu3));
            db.insertMenuItem("Phoenix Rolls", 10, drawableToByteArray(R.drawable.menu4));
            db.insertMenuItem("Burger", 4, drawableToByteArray(R.drawable.menu5));
            db.insertMenuItem("Sandwich", 2, drawableToByteArray(R.drawable.menu6));
            db.insertMenuItem("Momo", 7, drawableToByteArray(R.drawable.menu2));
            db.insertMenuItem("Phoenix Rolls", 8, drawableToByteArray(R.drawable.menu3));
            db.insertMenuItem("Momo", 10, drawableToByteArray(R.drawable.menu4));
            db.insertMenuItem("Burger", 4, drawableToByteArray(R.drawable.menu5));
            db.insertMenuItem("sandwich", 2, drawableToByteArray(R.drawable.menu6));

        }

        List<MenuItem> menuItems = db.getMenuItems();
        MenuAdapter adapter = new MenuAdapter(menuItems);
        binding.MenuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.MenuRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    private byte[] drawableToByteArray(int drawableId) {
        BitmapDrawable drawable = (BitmapDrawable) requireContext().getDrawable(drawableId);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
