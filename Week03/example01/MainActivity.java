package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox checkBox;
    RadioGroup rGroup;
    RadioButton rDog, rCat, rRabbit;
    Button buttonOk;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = findViewById(R.id.text1);
        checkBox = findViewById(R.id.checkAgree);

        text2 = findViewById(R.id.text2);
        rGroup = findViewById(R.id.rGroup1);
        rDog = findViewById(R.id.rDog);
        rCat = findViewById(R.id.rCat);
        rRabbit = findViewById(R.id.rRabbit);

        buttonOk = findViewById(R.id.buttonOk);
        image = findViewById(R.id.petImage);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBox.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    buttonOk.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    buttonOk.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(rGroup.getCheckedRadioButtonId()){
                    case R.id.rDog:
                        image.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rCat:
                        image.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rRabbit:
                        image.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}