package com.example.mulapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView text;
    EditText n1;
    Button button;
    int ans=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.text);
        n1=findViewById(R.id.n1);
        button =findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.button:
                StringBuffer buffer = new StringBuffer();
                int res;

                // get the input number from editText
                String fs = n1.getText().toString();

                // convert it to integer
                int n = Integer.parseInt(fs);

                // build the logic for table
                for (int i = 1; i <= 10; i++) {
                    ans = (i * n);
                    buffer.append(n + " * " + i
                            + " = " + ans + "\n\n");
                }

                // set the buffer textview
                text.setText(buffer);
                break;
        }
    }
}