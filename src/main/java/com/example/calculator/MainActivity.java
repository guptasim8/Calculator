package com.example.calculator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    EditText tv;

    TextView result,value;
    String tvs, results;
    Button button0, button1, button2, button3,
            button4, button5, button6, button7,
            button8, button9, buttonAdd, buttonSub,
            buttonDiv, buttonMul, buttonBack, buttonClear,
            buttonEqual, buttonAns, buttonPower, buttonDot,buttonClearAll,buttonLeft,buttonRight;

    //TextWatcher tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (EditText) findViewById(R.id.input);
        tv.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(tv.getWindowToken(), 0);
                }
            }
        });
        tv.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });
        tvs = tv.getText().toString();
        result = (TextView) findViewById(R.id.result);
        value = (TextView) findViewById(R.id.value);
        results = result.getText().toString();
        button0 = (Button) findViewById(R.id.zero);
        button1 = (Button) findViewById(R.id.one);
        button2 = (Button) findViewById(R.id.two);
        button3 = (Button) findViewById(R.id.three);

        button4 = (Button) findViewById(R.id.four);
        button5 = (Button) findViewById(R.id.five);
        button6 = (Button) findViewById(R.id.six);
        button7 = (Button) findViewById(R.id.seven);

        button8 = (Button) findViewById(R.id.eight);
        button9 = (Button) findViewById(R.id.nine);
        buttonDot = (Button) findViewById(R.id.dot);
        buttonAdd = (Button) findViewById(R.id.plus);

        buttonSub = (Button) findViewById(R.id.minus);
        buttonMul = (Button) findViewById(R.id.multiply);
        buttonDiv = (Button) findViewById(R.id.divide);
        buttonClear = (Button) findViewById(R.id.clear);
        buttonClearAll = (Button) findViewById(R.id.clearAll);

        buttonEqual = (Button) findViewById(R.id.equal);
        buttonBack = (Button) findViewById(R.id.back);
        buttonAns = (Button) findViewById(R.id.ans);
        buttonPower = (Button) findViewById(R.id.power);
        buttonLeft = (Button) findViewById(R.id.left);
        buttonRight = (Button) findViewById(R.id.right);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "1" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try {
                    result.setText(InfixFullParantEx.evaluateInfix(g.substring(0, j + 1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());
                tv.setSelection(i+1);
                buttonBack.setEnabled(true);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "2" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonBack.setEnabled(true);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "3" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonBack.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonClearAll.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "4" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonBack.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonClearAll.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "5" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try {
                    result.setText(InfixFullParantEx.evaluateInfix(g.substring(0, j + 1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "6" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "7" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try {
                    result.setText(InfixFullParantEx.evaluateInfix(g.substring(0, j + 1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "8" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });


        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "9" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "0" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        buttonAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + value.getText().toString() + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                tv.setSelection(i+value.getText().length());
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try {
                    result.setText(InfixFullParantEx.evaluateInfix(g.substring(0, j + 1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                if(!result.getText().toString().equalsIgnoreCase(""))
                buttonEqual.setEnabled(true);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
                buttonAdd.setEnabled(true);buttonSub.setEnabled(true);buttonMul.setEnabled(true);
                buttonDiv.setEnabled(true);buttonPower.setEnabled(true);buttonDot.setEnabled(true);
            }
        });
        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "^" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });


        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "." + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "+" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "-" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                try{
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;

                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "*" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);

                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });


        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "/" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvs = tv.getText().toString();
                int i = tv.getSelectionStart();
                String g;
                if (tvs.length() > 1) {
                    g=tv.getText().toString().substring(0, i - 1) +""+ tv.getText().toString().substring(i, tv.getText().toString().length());
                    tv.setText(g);
                    try{
                    int j=g.length()-1;

                    while((g.charAt(j)<'0'||g.charAt(j)>'9')&&j>=0)
                        j--;

                    result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                    }catch(Throwable t){
                        result.setText(R.string.wrongInput);
                    }
                    tv.setTextColor(button1.getTextColors());
                    tv.setTextColor(button1.getTextColors());
                    tv.setSelection(i-1);
                    // tv.setText(tvs.substring(0, (tvs.length() - 1)));
                } else if(tvs.length()==1) {
                    tv.setText("");
                    result.setText("");
                    buttonBack.setEnabled(false);
                    tv.setTextColor(button1.getTextColors());
                    tv.setSelection(0);
                    buttonClearAll.setEnabled(false);
                    //buttonAns.setEnabled(false);
                    buttonEqual.setEnabled(false);
                    buttonAdd.setEnabled(false);buttonMul.setEnabled(false);
                    buttonDiv.setEnabled(false);buttonPower.setEnabled(false);buttonDot.setEnabled(false);

                }

            }
        });
        buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv = (EditText) findViewById(R.id.input);
                tvs = tv.getText().toString();
                tv.setText("");
                result.setText("0");
                value.setText("");
                tv.setTextColor(button1.getTextColors());
                tv.setSelection(0);
                buttonBack.setEnabled(false);
                buttonClearAll.setEnabled(false);
                buttonAns.setEnabled(false);
                buttonEqual.setEnabled(false);
                buttonAdd.setEnabled(false);buttonMul.setEnabled(false);
                buttonDiv.setEnabled(false);buttonPower.setEnabled(false);buttonDot.setEnabled(false);
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv = (EditText) findViewById(R.id.input);
                tvs = tv.getText().toString();
                tv.setText("");
                result.setText("0");
                tv.setTextColor(button1.getTextColors());
                tv.setSelection(0);
                buttonBack.setEnabled(false);
                if(value.getText().toString().equalsIgnoreCase(""))
                buttonClearAll.setEnabled(false);
                buttonEqual.setEnabled(false);
                buttonAdd.setEnabled(false);buttonMul.setEnabled(false);
                buttonDiv.setEnabled(false);buttonPower.setEnabled(false);buttonDot.setEnabled(false);
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText(result.getText().toString());
                buttonAns.setEnabled(true);
            }
        });
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + "(" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                    result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonRight.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = tv.getSelectionStart();
                String g=tv.getText().toString().substring(0, i) + ")" + tv.getText().toString().substring(i, tv.getText().toString().length());
                tv.setText(g);
                int j=g.length()-1;
                while(g.charAt(j)<'0'||g.charAt(j)>'9')
                    j--;
                try{
                    result.setText(InfixFullParantEx.evaluateInfix(g.substring(0,j+1)));
                }catch(Throwable t){
                    result.setText(R.string.wrongInput);
                }
                tv.setTextColor(button1.getTextColors());tv.setSelection(i+1);
                buttonClearAll.setEnabled(true);
                buttonBack.setEnabled(true);
            }
        });


    }
}
/*
 tv = (EditText) findViewById(R.id.input);
                result = (TextView) findViewById(R.id.result);
                tvs=tv.getText()+"";
                int j=tv.getText().toString().length()-1;
                while(tv.getText().toString().charAt(j)<'0'||tv.getText().toString().charAt(j)>'9')
                    j--;
                result.setText(InfixFullParantEx.evaluateInfix(tv.getText().toString().substring(0,j+1)));

                tvs=tvs.substring(0,i)+'\0'+"";
                result.setText(InfixFullParantEx.evaluateInfix(tvs));
 */