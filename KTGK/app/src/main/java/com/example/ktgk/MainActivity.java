package com.example.ktgk;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etHoTen, etMSSV, etLop;
    private RadioGroup radioGroupGioiTinh;
    private CheckBox checkboxJavascript, checkboxPHP, checkboxMobileDev;
    private Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHoTen = findViewById(R.id.edtHoTen);
        etMSSV = findViewById(R.id.edtMSSV);
        etLop = findViewById(R.id.edtLop);
        radioGroupGioiTinh = findViewById(R.id.radioGroupGioiTinh);
        checkboxJavascript = findViewById(R.id.cbJavascript);
        checkboxPHP = findViewById(R.id.cbPHP);
        checkboxMobileDev = findViewById(R.id.cbMobile);
        btnGui = findViewById(R.id.btnGui);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hoTen = etHoTen.getText().toString();
                String mssv = etMSSV.getText().toString();
                String lop = etLop.getText().toString();

                if (hoTen.isEmpty() || hoTen.length() < 20) {
                    etHoTen.setError("Tên phải có ít nhất 20 ký tự");
                    return;
                }

                if (mssv.isEmpty() || mssv.length() != 8) {
                    etMSSV.setError("MSSV phải có 8 chữ số");
                    return;
                }

                if (!checkboxJavascript.isChecked() && !checkboxPHP.isChecked() && !checkboxMobileDev.isChecked()) {
                    Toast.makeText(MainActivity.this, "Chọn ít nhất 1 môn học", Toast.LENGTH_SHORT).show();
                    return;
                }

                String gioiTinh = ((RadioButton) findViewById(radioGroupGioiTinh.getCheckedRadioButtonId())).getText().toString();

                StringBuilder monHoc = new StringBuilder();
                if (checkboxJavascript.isChecked()) {
                    monHoc.append("Javascript, ");
                }
                if (checkboxPHP.isChecked()) {
                    monHoc.append("PHP, ");
                }
                if (checkboxMobileDev.isChecked()) {
                    monHoc.append("Lập trình cho thiết bị di động, ");
                }

                if (monHoc.length() > 0) {
                    monHoc.setLength(monHoc.length() - 2);
                }

                String lopMessage =  lop;

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thông tin sinh viên")
                        .setMessage("Họ và tên: " + hoTen + "\n"
                                + "MSSV: " + mssv + "\n"
                                + "Giới tính: " + gioiTinh + "\n"
                                + "Môn đã đăng ký: " + monHoc.toString() + "\n"
                                + lopMessage)
                        .setPositiveButton("Đóng", null)
                        .show();
            }
        });
    }
}
