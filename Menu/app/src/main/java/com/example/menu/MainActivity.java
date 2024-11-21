package com.example.menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Xử lý PopupMenu
        Button popupButton = findViewById(R.id.popup_button); // Chắc chắn rằng bạn đã tạo nút này trong layout
        popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        // Đăng ký ContextMenu
        TextView contextText = findViewById(R.id.context_text); // Chắc chắn rằng bạn đã tạo TextView này trong layout
        registerForContextMenu(contextText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu); // Inflate menu từ file menu.xml
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        handleMenuItemSelection(item); // Gọi hàm xử lý khi một mục menu được chọn
        return super.onOptionsItemSelected(item);
    }

    // Hàm xử lý các mục menu
    private void handleMenuItemSelection(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.them) {
            Toast.makeText(this, "Đây là nút thêm", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.sua) {
            Toast.makeText(this, "Đây là nút sửa", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.xoa) {
            Toast.makeText(this, "Đây là nút xóa", Toast.LENGTH_SHORT).show();
        }
    }

    // Hiển thị PopupMenu
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.them) {
                    ((Button) view).setText("Thêm"); // Cập nhật text cho nút
                    Toast.makeText(MainActivity.this, "Chọn thêm từ PopupMenu", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.sua) {
                    Toast.makeText(MainActivity.this, "Chọn sửa từ PopupMenu", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.xoa) {
                    Toast.makeText(MainActivity.this, "Chọn xóa từ PopupMenu", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        popupMenu.show();
    }

    // Hàm xử lý ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu); // Inflate menu cho ContextMenu
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        handleMenuItemSelection(item); // Gọi hàm xử lý khi một mục context menu được chọn
        return super.onContextItemSelected(item);
    }
}
