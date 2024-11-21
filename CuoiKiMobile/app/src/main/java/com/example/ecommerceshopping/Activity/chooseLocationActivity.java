package com.example.ecommerceshopping.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceshopping.databinding.ActivityChooseLocationBinding;

public class chooseLocationActivity extends AppCompatActivity {
    private ActivityChooseLocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityChooseLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Danh sách các địa điểm
        String[] locationlist = new String[] {
                "Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "Vũng Tàu", "Bình Thuận", "Ninh Bình", "Bắc Ninh"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationlist);
        AutoCompleteTextView autoCompleteTextView = binding.ListOfLocation; // Lấy AutoCompleteTextView từ binding
        autoCompleteTextView.setAdapter(adapter);

        binding.buttonBackLocation.setOnClickListener(view -> {
            finish();
        });
        autoCompleteTextView.setOnClickListener(view -> autoCompleteTextView.showDropDown());
    }
}
