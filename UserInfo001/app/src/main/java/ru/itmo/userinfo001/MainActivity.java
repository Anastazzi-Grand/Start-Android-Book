package ru.itmo.userinfo001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvYear;
    EditText etName, etYear;
    Button button;
    String stName, stYear;
    int year, myYear, myAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvYear = findViewById(R.id.tvYear);
        etName = findViewById(R.id.etName);
        etYear = findViewById(R.id.etYear);
        button = findViewById(R.id.button);
    }

    public void goDoIt(View view) {

        stName = etName.getText().toString();
        stYear = etYear.getText().toString();

        if (stName.equals("")) return;

        year = Calendar.getInstance().get(Calendar.YEAR);
        myYear = Integer.parseInt(stYear);
        if (myYear > year) return;

        myAge = year - myYear;
        Toast.makeText(this, stName + ", your age " + myAge + " years", Toast.LENGTH_LONG).show();

    }
}