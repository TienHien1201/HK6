package com.example.lab23;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";  // Dùng để log lỗi dễ dàng
    BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);
            navView = findViewById(R.id.nav_view);  // Đảm bảo `id` khớp với layout XML

            if (navView == null) {
                throw new NullPointerException("nav_view is null. Check if R.id.nav_view exists in activity_main layout.");
            }

            // Hiển thị fragment mặc định khi bắt đầu
            loadFragment(new HomeFragment());

            // Thiết lập sự kiện cho từng item và thêm Log để ghi lại quá trình
            MenuItem dashboardItem = navView.getMenu().findItem(R.id.navigation_dashboard);
            MenuItem homeItem = navView.getMenu().findItem(R.id.navigation_home);
            MenuItem notificationsItem = navView.getMenu().findItem(R.id.navigation_notifications);
            MenuItem accountItem = navView.getMenu().findItem(R.id.navigation_account);

            dashboardItem.setOnMenuItemClickListener(item -> {
                Log.d(TAG, "Dashboard item clicked");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Dashboard");
                }
                loadFragment(new DashboardFragment());
                return true;
            });

            homeItem.setOnMenuItemClickListener(item -> {
                Log.d(TAG, "Home item clicked");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Home");
                }
                loadFragment(new HomeFragment());
                return true;
            });

            notificationsItem.setOnMenuItemClickListener(item -> {
                Log.d(TAG, "Notifications item clicked");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Notification");
                }
                loadFragment(new NotificationsFragment());
                return true;
            });

            accountItem.setOnMenuItemClickListener(item -> {
                Log.d(TAG, "Account item clicked");
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("Profile");
                }
                loadFragment(new AccountFragment());
                return true;
            });

        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate: ", e);
            Toast.makeText(this, "Error in onCreate: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    // Hàm loadFragment dùng để thay thế fragment
    private void loadFragment(Fragment fragment) {
        try {
            Log.d(TAG, "Loading fragment: " + fragment.getClass().getSimpleName());
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment, fragment);  // Đảm bảo R.id.nav_host_fragment tồn tại
            transaction.addToBackStack(null);  // Cho phép quay lại fragment trước
            transaction.commit();  // Thực hiện giao dịch fragment
        } catch (Exception e) {
            Log.e(TAG, "Error in loadFragment: ", e);
            Toast.makeText(this, "Error loading fragment: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
