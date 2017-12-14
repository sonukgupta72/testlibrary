package com.incred.fcm_example.testlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.incred.fcm_example.indianamountformat.AmountFormat;
import com.incred.fcm_example.numbertoword.NumberToWord;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String word = new NumberToWord().getRupeeInWords(1234567891);
        Toast.makeText(this, word, Toast.LENGTH_LONG).show();

        String commaString = AmountFormat.formatIndianAmount("123456");
        Toast.makeText(this, commaString, Toast.LENGTH_LONG).show();
    }
}
