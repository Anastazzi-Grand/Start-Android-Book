package ru.itmo.randomnumbers001;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber;
    Button btnRandNumber1, btnRandNumber2, btnRandNumber3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber = findViewById(R.id.tvNumber);
        btnRandNumber1 = findViewById(R.id.btnRandNumber1);
        btnRandNumber2 = findViewById(R.id.btnRandNumber2);
        btnRandNumber3 = findViewById(R.id.btnRandNumber3);
    }

    @SuppressLint("SetTextI18n")
    public void newNumber(View view) {
        int num = 0;
        if (view == btnRandNumber1) {
            num = 1 + (int) (9 * Math.random());
        }
        if (view == btnRandNumber2) {
            num = 10 + (int) (90 * Math.random());
        }
        if (view == btnRandNumber3) {
            num = 100 + (int) (900 * Math.random());
        }
        tvNumber.setText("Received number = " + num);
//        btnRandNumber1.setText("Click again to get a new number");
    }
}