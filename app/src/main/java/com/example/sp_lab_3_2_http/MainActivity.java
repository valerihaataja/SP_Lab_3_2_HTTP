package com.example.sp_lab_3_2_http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NetworkThread.MyInterface, View.OnClickListener {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(this);
    }

    @Override
    public void palauta(String palautus) {
        textView.setText(palautus);
    }

    @Override
    public void onClick(View v) {
        NetworkThread n = new NetworkThread(this, editText.getText().toString());
        n.start();
    }
}
