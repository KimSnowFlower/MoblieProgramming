package com.example.a20231129;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        String calc = (inIntent.getStringExtra("Calc"));

        int calValue = 0;

        if(calc.equals("+")){
            calValue = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("-")){
            calValue = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("*")){
            calValue = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        }
        else if(calc.equals("/")){
            calValue = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
        }
        else{
            Toast.makeText(getApplicationContext(), "없는 기호입니다.", Toast.LENGTH_SHORT).show();
        }

        final int retValue = calValue;

        Button returnBtn = findViewById(R.id.returnBtn);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
