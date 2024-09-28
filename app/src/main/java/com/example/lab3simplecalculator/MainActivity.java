package com.example.lab3simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private enum Operator {none,name,add,minus,multiply,divide}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void btn0(View view){
        TextView eText = (TextView) findViewById(R.id.buttonZero);
        eText.setText(eText.getText()+ "0");
    }
    public void btn01(View view){
        TextView eText = (TextView) findViewById(R.id.button1);
        eText.setText(eText.getText()+ "1");
    }
    public void btn02(View view){
        TextView eText = (TextView) findViewById(R.id.button2);
        eText.setText(eText.getText()+ "2");
    }
    public void btn03(View view){
        TextView eText = (TextView) findViewById(R.id.button3);
        eText.setText(eText.getText()+ "3");
    }
    public void btn04(View view){
        TextView eText = (TextView) findViewById(R.id.button4);
        eText.setText(eText.getText()+ "4");
    }
    public void btn05(View view){
        TextView eText = (TextView) findViewById(R.id.button5);
        eText.setText(eText.getText()+ "5");
    }
    public void btn06(View view){
        TextView eText = (TextView) findViewById(R.id.button6);
        eText.setText(eText.getText()+ "6");
    }
    public void btn07(View view){
        TextView eText = (TextView) findViewById(R.id.button7);
        eText.setText(eText.getText()+ "7");
    }
    public void btn08(View view){
        TextView eText = (TextView) findViewById(R.id.button8);
        eText.setText(eText.getText()+ "8");
    }
    public void btn09(View view){
        TextView eText = (TextView) findViewById(R.id.button9);
        eText.setText(eText.getText()+ "9");
    }

    public void btnSUB(View view){
        TextView eText = (TextView) findViewById(R.id.buttonSub);
        eText.setText(eText.getText()+ "-");
    }
    public void btnCLEAR(View view){
        TextView eText = (TextView) findViewById(R.id.buttonClear);
        eText.setText(eText.getText()+ "CE");
    }
    public void btnDEC(View view){
        TextView eText = (TextView) findViewById(R.id.ButtonDecimal);
        eText.setText(eText.getText()+ ".");
    }
    public void btnMULT(View view){
        TextView eText = (TextView) findViewById(R.id.buttonMULT);
        eText.setText(eText.getText()+ "*");
    }
    public void btnEQUAL(View view) {
        if (optr != Operator.none) {
            TextView eText = (TextView) findViewById(R.id.buttonEqual);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr == Operator.add) {
                result = data1 + data2;
            } else if (optr == Operator.minus) {
                result = data1 - data2;
            } else if (optr == Operator.multiply) {
                result = data1 * data2;
            } else if (optr == Operator.divide) {
                result = data1 / data2;
            }

            optr = Operator.none;
            data1 = result;
            if ((result - (int) result) != 0) {
                eText.setText(String.valueOf(result));
            } else {
                eText.setText(String.valueOf((int) result));
            }
        }
    }

}
