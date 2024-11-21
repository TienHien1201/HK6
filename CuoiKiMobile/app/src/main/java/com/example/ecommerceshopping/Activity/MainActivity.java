package com.example.ecommerceshopping.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.ecommerceshopping.Model.UserSession;
import com.example.ecommerceshopping.Fragment.Notifaction_Bottom_Fragment;
import com.example.ecommerceshopping.R;
import com.example.ecommerceshopping.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TextView welcomeMessage;
    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userSession = UserSession.getInstance();
        String username = userSession.getUsername();

        // Tạo và hiển thị lời chào
        welcomeMessage = findViewById(R.id.welcomeMessage);
        if (username != null) {
            welcomeMessage.setText("Welcome " + username + "!");
        }

        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView5);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNav, navController);
        binding.locationImage.setOnClickListener(view -> {
                Intent intent = new Intent(this, chooseLocationActivity.class);
                startActivity(intent);
        });
        binding.NotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notifaction_Bottom_Fragment bottomSheetDialog = new Notifaction_Bottom_Fragment();
                bottomSheetDialog.show(getSupportFragmentManager(), "test");
            }
        });
    }
}
