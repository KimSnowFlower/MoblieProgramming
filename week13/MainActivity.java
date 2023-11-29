package com.example.a20231129;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");

        final EditText edtText1 = findViewById(R.id.edtNum1);
        final EditText edtText2 = findViewById(R.id.edtNum2);
        final RadioGroup rGroup = findViewById(R.id.raidoGroup);
        Button newActivityBtn = findViewById(R.id.newActivityBtn);

        newActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.addBtn:
                        intent.putExtra("Calc", "+");
                        break;
                    case R.id.subBtn:
                        intent.putExtra("Calc", "-");
                        break;
                    case R.id.mulBtn:
                        intent.putExtra("Calc", "*");
                        break;
                    case R.id.divBtn:
                        intent.putExtra("Calc", "/");
                        break;
                    default:
                        break;
                }

                intent.putExtra("Num1", Integer.parseInt(edtText1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtText2.getText().toString()));

                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "결과 : " + hap, Toast.LENGTH_SHORT).show();
        }
    }
}