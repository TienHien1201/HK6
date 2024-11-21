package com.example.lab2checkboxradioandcsroll;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;


public class check_box_labclass extends AppCompatActivity {

    CheckBox kemBo, kemSauRieng, kemDau;
    RadioButton sizeS, sizeM, sizeL;
    EditText selectedIceCream, selectedSize;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_labclass);


        kemBo = findViewById(R.id.checkBoxBo);
        kemSauRieng = findViewById(R.id.checkBoxSocola);
        kemDau = findViewById(R.id.checkBoxChuoi);


        sizeS = findViewById(R.id.radio_s);
        sizeM = findViewById(R.id.radio_m);
        sizeL = findViewById(R.id.radio_l);

        selectedIceCream = findViewById(R.id.selected_click);
        selectedSize = findViewById(R.id.selected_size);

        View.OnClickListener checkBoxListener = v -> {
            StringBuilder selected = new StringBuilder();

            if (kemBo.isChecked()) selected.append("Kem bơ, ");
            if (kemSauRieng.isChecked()) selected.append("Kem sầu riêng, ");
            if (kemDau.isChecked()) selected.append("Kem dâu, ");

            selectedIceCream.setText(selected.toString());
        };

        kemBo.setOnClickListener(checkBoxListener);
        kemSauRieng.setOnClickListener(checkBoxListener);
        kemDau.setOnClickListener(checkBoxListener);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(sizeS.isChecked()) {

                selectedSize.setText("S");
            }else
            if(sizeM.isChecked()){

                selectedSize.setText("M");}
            else if(sizeL.isChecked()){
                selectedSize.setText("L");
            }

        });
    }
}