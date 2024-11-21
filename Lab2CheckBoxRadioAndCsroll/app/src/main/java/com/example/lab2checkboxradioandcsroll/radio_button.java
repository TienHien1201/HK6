package com.example.lab2checkboxradioandcsroll;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class radio_button extends AppCompatActivity {

    private CheckBox cbInt, cbDouble, cbString, cbAll;
    private Button btnKetQua, btnGoiY;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.radio_button);




//        setContentView(R.layout.scrollviewheight);
//        Button btnScrollUp = findViewById(R.id.btn_scroll_up);
//        Button btnScrollDown = findViewById(R.id.btn_scroll_down);
//        ScrollView scrollView = findViewById(R.id.scrollView);
//        btnScrollUp.setOnClickListener(v -> scrollView.scrollBy(0, -150));
//        btnScrollDown.setOnClickListener(v -> scrollView.scrollBy(0, 150));

//
//        setContentView(R.layout.srollviewwidth);
//        Button btnScrollLeft = findViewById(R.id.btn_scroll_left);
//        Button btnScrollRight = findViewById(R.id.btn_scroll_right);
//        HorizontalScrollView horizontalScrollView = findViewById(R.id.horizontalScrollView);
//        btnScrollLeft.setOnClickListener(v -> horizontalScrollView.scrollBy(-100, 0));
//        btnScrollRight.setOnClickListener(v -> horizontalScrollView.scrollBy(100, 0));}


//
//
//
//
//        setContentView(R.layout.check_box);
//        cbInt = findViewById(R.id.cb_int);
//        cbDouble = findViewById(R.id.cb_double);
//        cbString = findViewById(R.id.cb_string);
//        cbAll = findViewById(R.id.cb_all);
//        btnKetQua = findViewById(R.id.btn_ket_qua);
//        btnGoiY = findViewById(R.id.btn_goi_y);
//        tvResult = findViewById(R.id.tv_result);
//        btnKetQua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cbString.isChecked() && !cbInt.isChecked() && !cbDouble.isChecked() && !cbAll.isChecked())  {
//                    tvResult.setText("True");
//                    tvResult.setVisibility(View.VISIBLE);
//                    tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
//                    btnGoiY.setEnabled(false);
//                } else {
//                    tvResult.setText("Sai rồi!");
//                    tvResult.setVisibility(View.VISIBLE);
//                    tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
//                    btnGoiY.setEnabled(true);
//                }
//            }
//        });
//
//        btnGoiY.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Gợi ý: Tên thành phố là một chuỗi ký tự!", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        cbAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                cbInt.setChecked(false);
//                cbDouble.setChecked(false);
//                cbString.setChecked(false);
//            }
//        });
//
//        // Khi người dùng chọn các check box riêng lẻ, bỏ chọn 'Tất cả các phương án'
//        View.OnClickListener checkListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (cbInt.isChecked() || cbDouble.isChecked() || cbString.isChecked()) {
//                    cbAll.setChecked(false);
//                }
//            }
//        };
//
//        cbInt.setOnClickListener(checkListener);
//        cbDouble.setOnClickListener(checkListener);
//        cbString.setOnClickListener(checkListener);
//
//



    }
}
