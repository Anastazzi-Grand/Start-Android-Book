package ru.itmo.countries001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button[] btns = new Button[6];
    ImageView ivEmbl, ivFlag;
    TextView tvName;
    int[] embl = {R.drawable.israel1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goPict(View view) {
    }
}