package com.example.listview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ListView listView = findViewById(R.id.listView);
        NavigationView navigationView = findViewById(R.id.navigationView);

        ArrayList<SinhVien> arrayList = new ArrayList<>();
        arrayList.add(new SinhVien("A", 18, R.drawable.facebook));
        arrayList.add(new SinhVien("B", 19, R.drawable.google));

        SinhVienAdapter adapter = new SinhVienAdapter(MainActivity.this, R.layout.sinh_vien_item, arrayList);
        listView.setAdapter(adapter);

        // Thiết lập sự kiện cho từng item của NavigationView
        MenuItem homeItem = navigationView.getMenu().findItem(R.id.nav_home);
        MenuItem profileItem = navigationView.getMenu().findItem(R.id.nav_profile);
        MenuItem settingsItem = navigationView.getMenu().findItem(R.id.nav_settings);
        MenuItem aboutItem = navigationView.getMenu().findItem(R.id.nav_about);

        // Gán sự kiện cho từng item
        homeItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
            return true;
        });

        profileItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Profile selected", Toast.LENGTH_SHORT).show();
            return true;
        });

        settingsItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "Settings selected", Toast.LENGTH_SHORT).show();
            return true;
        });

        aboutItem.setOnMenuItemClickListener(item -> {
            Toast.makeText(MainActivity.this, "About selected", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}
