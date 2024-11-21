package com.example.ecommerceshopping.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.databinding.ActivitySignUpBinding;

public class sign_up extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private DatabaseEcommerceShopingOnline db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new DatabaseEcommerceShopingOnline(this);

        binding.loginLink.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        });

        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.nameInput.getText().toString().trim();
            String password = binding.passwordInput.getText().toString().trim();

            if (!username.equalsIgnoreCase("user") && !username.equalsIgnoreCase("admin")) {
                Toast.makeText(this, "Tên đăng nhập phải là 'user' hoặc 'admin'", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                return;
            }

            String role = username.equalsIgnoreCase("admin") ? "admin" : "user";

            if (insertUserIntoDatabase(username, password, role)) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Tên đăng nhập đã tồn tại", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean insertUserIntoDatabase(String username, String password, String role) {
        SQLiteDatabase db = this.db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("role", role);

        long result = -1;
        try {
            result = db.insert("users", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return result != -1;
    }

}
