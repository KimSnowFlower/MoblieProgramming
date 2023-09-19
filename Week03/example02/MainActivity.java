package com.example.project4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch aSwitch;
    RadioGroup rGroup;
    RadioButton rV11, rS12, rT13;
    ImageView imageView1;
    Button exitBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icon);
        setTitle("안드로이드 사진 보기");

        text1 = findViewById(R.id.text1);
        aSwitch = findViewById(R.id.switch1);

        text2 = findViewById(R.id.text2);
        rGroup = findViewById(R.id.rGroup1);
        rV11 = findViewById(R.id.rV11);
        rS12 = findViewById(R.id.rV12);
        rT13 = findViewById(R.id.rV13);

        imageView1 = findViewById(R.id.iconImage);
        exitBtn = findViewById(R.id.exitBtn);
        resetBtn = findViewById(R.id.resetBtn);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(aSwitch.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    rV11.setVisibility(View.VISIBLE);
                    rS12.setVisibility(View.VISIBLE);
                    rT13.setVisibility(View.VISIBLE);
                    imageView1.setVisibility(View.VISIBLE);
                    exitBtn.setVisibility(View.VISIBLE);
                    resetBtn.setVisibility(View.VISIBLE);
                }
                else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    rV11.setVisibility(View.INVISIBLE);
                    rS12.setVisibility(View.INVISIBLE);
                    rT13.setVisibility(View.INVISIBLE);
                    imageView1.setVisibility(View.INVISIBLE);
                    exitBtn.setVisibility(View.INVISIBLE);
                    resetBtn.setVisibility(View.INVISIBLE);
                }
            }
        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(rGroup.getCheckedRadioButtonId()){
                    case R.id.rV11:
                        imageView1.setImageResource(R.drawable.r11);
                        break;
                    case R.id.rV12:
                        imageView1.setImageResource(R.drawable.s12);
                        break;
                    case R.id.rV13:
                        imageView1.setImageResource(R.drawable.t13);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "선택 안함",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aSwitch.setChecked(false);
                text2.setVisibility(View.INVISIBLE);
                rGroup.setVisibility(View.INVISIBLE);
                rV11.setVisibility(View.INVISIBLE);
                rV11.setChecked(false);
                rS12.setVisibility(View.INVISIBLE);
                rS12.setChecked(false);
                rT13.setVisibility(View.INVISIBLE);
                rT13.setChecked(false);
                imageView1.setImageResource(0);
                exitBtn.setVisibility(View.INVISIBLE);
                resetBtn.setVisibility(View.INVISIBLE);
            }
        });
    }
}