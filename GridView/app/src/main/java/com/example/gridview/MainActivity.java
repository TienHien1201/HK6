package com.example.gridview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridview);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Tạo danh sách các đối tượng Furniture với drawable ID
        List<Furniture> furnitureList = new ArrayList<>();
        furnitureList.add(new Furniture("Sofa", "Comfortable sofa", R.drawable.furniture));
        furnitureList.add(new Furniture("Chair", "Wooden chair", R.drawable.background));
        furnitureList.add(new Furniture("Table", "Dining table", R.drawable.facebook));
        furnitureList.add(new Furniture("Lamp", "Bedside lamp", R.drawable.google));

        // Sử dụng FurnitureAdapterGrid để hiển thị danh sách
        FurnitureAdapterGrid adapter = new FurnitureAdapterGrid(this, R.layout.items, furnitureList);
        gridView.setAdapter(adapter);

        // Thiết lập sự kiện cho từng item của NavigationView
        MenuItem homeItem = bottomNavigationView.getMenu().findItem(R.id.nav_home);
        MenuItem profileItem = bottomNavigationView.getMenu().findItem(R.id.nav_profile);
        MenuItem settingsItem = bottomNavigationView.getMenu().findItem(R.id.nav_settings);
        MenuItem aboutItem = bottomNavigationView.getMenu().findItem(R.id.nav_about);

        // Gán sự kiện cho từng item
        homeItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
            return true;
        });

        profileItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Info selected", Toast.LENGTH_SHORT).show();
            return true;
        });

        settingsItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Email selected", Toast.LENGTH_SHORT).show();
            return true;
        });

        aboutItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "About selected", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
    }

