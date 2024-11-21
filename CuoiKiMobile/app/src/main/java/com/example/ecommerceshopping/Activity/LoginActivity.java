package com.example.ecommerceshopping.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceshopping.DataConnection.DatabaseEcommerceShopingOnline;
import com.example.ecommerceshopping.Model.User;
import com.example.ecommerceshopping.Model.UserSession;
import com.example.ecommerceshopping.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private DatabaseEcommerceShopingOnline db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new DatabaseEcommerceShopingOnline(this);

        binding.CheckPass.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Hiển thị mật khẩu
                binding.passwordInput.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                binding.passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }
            binding.passwordInput.setSelection(binding.passwordInput.getText().length());
        });
        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.UserNameInput.getText().toString().trim();
            String password = binding.passwordInput.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            User user = db.authenticateUser(username, password);
            if (user != null) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                UserSession.getInstance().setUser(user.getId(), user.getUsername(), user.getRole());

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                finish();
            } else {
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        binding.signUpLink.setOnClickListener(view -> {
            Intent intent = new Intent(this, sign_up.class);
            startActivity(intent);
        });
    }
}
