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
    int[] embl = {R.drawable.israel1, R.drawable.usa1, R.drawable.russia1, R.drawable.germany1, R.drawable.poland1, R.drawable.france1};
    int[] flag = {R.drawable.israel2, R.drawable.usa2, R.drawable.russia2, R.drawable.germany2, R.drawable.poland2, R.drawable.france2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goPict(View view) {
    }
}