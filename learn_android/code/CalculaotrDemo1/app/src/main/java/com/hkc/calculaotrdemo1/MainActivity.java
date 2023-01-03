package com.hkc.calculaotrdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import org.mariuszgromada.math.mxparser.*;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import com.hkc.calculaotrdemo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
//    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

//        display = binding.display;
        binding.display.setShowSoftInputOnFocus(false);

        binding.display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.display).equals(binding.display.getText().toString())){
                    binding.display.setText("");
                }

            }
        });


    }

    private void updateText(String stringToAdd){
        String oldString = binding.display.getText().toString();
        int cursorPosition = binding.display.getSelectionStart();
        String leftString = oldString.substring(0,cursorPosition);
        String rightString = oldString.substring(cursorPosition);
        if(getString(R.string.display).equals(binding.display.getText().toString())) {
            binding.display.setText(stringToAdd);
            binding.display.setSelection(cursorPosition + 1);
        }else {
            binding.display.setText(String.format("%s%s%s", leftString, stringToAdd, rightString));
            binding.display.setSelection(cursorPosition + 1);
        }


    }

    public void zeroBTN(View view){
        updateText("0");

    }
    public void oneBTN(View view){
        updateText("1");

    }
    public void twoBTN(View view){
        updateText("2");

    }
    public void threeBTN(View view){
        updateText("3");

    }
    public void fourBTN(View view){
        updateText("4");

    }
    public void fiveBTN(View view){
        updateText("5");

    }
    public void sixBTN(View view){
        updateText("6");

    }
    public void sevenBTN(View view){
        updateText("7");

    }
    public void eightBTN(View view){
        updateText("8");

    }
    public void nineBTN(View view){
        updateText("9");

    }
    public void buttonparentheses(View view){
        int cursorPosition = binding.display.getSelectionStart();
        int openparentheses = 0;
        int closeparentheses = 0;
        int txtlength = binding.display.getText().length();

        for(int i = 0; i <cursorPosition;i++){
            if(binding.display.getText().toString().substring(i,i+1).equals("(")){
                openparentheses += 1;
            }
            if(binding.display.getText().toString().substring(i,i+1).equals(")")){
                closeparentheses += 1;
            }
        }
        if(openparentheses == closeparentheses || binding.display.getText().toString().substring(txtlength-1, txtlength).equals("")){
            updateText("(");
//            binding.display.setSelection(cursorPosition + 1);


        }
        else if(closeparentheses < openparentheses && !binding.display.getText().toString().substring(txtlength-1, txtlength).equals("")){
            updateText(")");
//            binding.display.setSelection(cursorPosition + 1);


        }
        binding.display.setSelection(cursorPosition + 1);

    }
    public void buttonclear(View view){
        binding.display.setText("");

    }
    public void buttonexponent(View view){
        updateText("^");

    }
    public void buttondivide(View view){
        updateText("/");

    }
    public void buttonmultiply(View view){
        updateText("*");

    }
    public void buttonsubtract(View view){
        updateText("-");

    }
    public void buttonadd(View view){
        updateText("+");

    }

    public void buttonpoint(View view){
        updateText(".");

    }
    public void buttonplusMinus(View view){
        updateText("-");

    }
    public void buttonbackspace(View view){
        int cursorPosition = binding.display.getSelectionStart();
        int txtLength = binding.display.getText().length();

        if (cursorPosition != 0 && txtLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) binding.display.getText();
            selection.replace(cursorPosition - 1, cursorPosition, "");
            binding.display.setText(selection);
            binding.display.setSelection(cursorPosition - 1);


        }


    }
    public void buttonequal(View view){
        String userExpression = binding.display.getText().toString();
        userExpression = userExpression.replaceAll("÷","/" );
        userExpression = userExpression.replaceAll("×","*" );

        Expression expression = new Expression(userExpression);

        String result = String.valueOf(expression.calculate());
        binding.display.setText(result);
        binding.display.setSelection(result.length());


    }

}