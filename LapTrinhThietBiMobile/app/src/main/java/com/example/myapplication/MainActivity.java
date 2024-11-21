package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Liên kết với các phần tử giao diện
        TextView textView = findViewById(R.id.show_count);

        Button button = findViewById(R.id.button_toast);
        Button button1 = findViewById(R.id.button_count);
        // Thiết lập sự kiện khi nhấn nút
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           String e = textView.getText().toString() ;

           textView.setText(e );

            }
        });
    }
}
