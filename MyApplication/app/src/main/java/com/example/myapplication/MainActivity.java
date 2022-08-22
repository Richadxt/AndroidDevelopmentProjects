package com.example.myapplication;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnQRCode;
    EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.inputText);
        imageView= findViewById(R.id.imageView);
        btnQRCode= findViewById(R.id.generateBtn);
        btnQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(textView.getText())){
                    String text = textView.getText().toString();
                    Bitmap qrCode = createBitmap(text);
                    imageView.setImageBitmap(qrCode);
                }
            }
        });
    }

    private Bitmap createBitmap(String text) {
        BitMatrix result;
        try {
            result= new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE,
                    300,300,null);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        for(int x=0;x<height;x++)
        {
            int offset = x * width;
            for(int k=0; k<width;k++)
            {
               pixels[offset + k] = result.get(k, x) ? BLACK : WHITE;
            }
        }
        Bitmap myBitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        myBitmap.setPixels(pixels,0,width,0,0,width, height);
        return myBitmap;
    }
}