package com.example.hw04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    RadioGroup rGroup1, rGroup2;
    ImageView imageView;
    TextView textView;
    View dialogView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HWork04");

        btn1 = findViewById(R.id.showBtn);
        rGroup1 = findViewById(R.id.rGroup1);
        rGroup2 = findViewById(R.id.rGroup2);

        rGroup1.clearCheck();
        rGroup2.clearCheck();

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dialogView = View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("선택한 동물: ");
                dlg.setView(dialogView);

                imageView = dialogView.findViewById(R.id.imageView1);
                textView = dialogView.findViewById(R.id.digTextView);

                switch (rGroup1.getCheckedRadioButtonId()){
                    case R.id.rDog:
                        dlg.setTitle("선택한 동물: 강아지");
                        imageView.setImageResource(R.drawable.dog);
                        textView.setText("강아지");
                        break;
                    case R.id.rCat:
                        dlg.setTitle("선택한 동물: 고양이");
                        imageView.setImageResource(R.drawable.cat);
                        textView.setText("고양이");
                        break;
                    case R.id.rRabbit:
                        dlg.setTitle("선택한 동물: 토끼");
                        imageView.setImageResource(R.drawable.rabbit);
                        textView.setText("토끼");
                        break;
                    case R.id.rHorse:
                        dlg.setTitle("선택한 동물: 말");
                        imageView.setImageResource(R.drawable.horse);
                        textView.setText("말");
                        break;
                }

                switch (rGroup2.getCheckedRadioButtonId()){
                    case R.id.redBtn:
                        textView.setTextColor(Color.RED);
                        break;
                    case R.id.greenBtn:
                        textView.setTextColor(Color.GREEN);
                        break;
                    case R.id.blueBtn:
                        textView.setTextColor(Color.BLUE);
                        break;
                }

                dlg.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        rGroup1.clearCheck();
                        rGroup2.clearCheck();
                    }
                });

                dlg.show();
            }
        });
    }
}