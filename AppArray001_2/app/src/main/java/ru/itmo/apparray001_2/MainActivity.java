package ru.itmo.apparray001_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etVal;
    Button btnFill, btnSum, btnMaMi, btnFind;
    int[] tv = {R.id.tv0, R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,R.id.tv6, R.id.tv7, R.id.tv8};
    TextView[] tvs = new TextView[9];
    int[] nums = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVal = findViewById(R.id.etVal);
        btnFill = findViewById(R.id.btnFill);
        btnSum = findViewById(R.id.btnSum);
        btnMaMi = findViewById(R.id.btnMaMi);
        btnFind = findViewById(R.id.btnFind);

        for (int i = 0; i < tv.length; i++) tvs[i] = findViewById(tv[i]);
    }

    @SuppressLint("SetTextI18n")
    public void fillArray(View view) {
        for (int i = 0; i < nums.length; i++) nums[i] = 10 + (int) ((99 - 10 + 1) * Math.random());
        for (int i = 0; i < nums.length; i++) tvs[i].setText("" + nums[i]);
        for (int i = 0; i < nums.length; i++) {
            tvs[i].setTextColor(Color.BLACK);
            tvs[i].setBackgroundColor(Color.WHITE);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void sumArray(View view) {
        int sum = Arrays.stream(nums).sum();
        Toast.makeText(this, "Sum of array = " + sum, Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void maxMin(View view) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) tvs[i].setTextColor(Color.GREEN);
            if (nums[i] == max) tvs[i].setTextColor(Color.RED);
        }
    }

    public void findValue(View view) {
        String t = etVal.getText().toString();
        if (t.equals("")) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            etVal.setText("");
            return;
        }

        int x = Integer.parseInt(t);
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == x) {
                tvs[i].setTextColor(Color.WHITE);
                tvs[i].setBackgroundColor(Color.BLACK);
            }
    }
}