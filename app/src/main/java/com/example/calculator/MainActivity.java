package com.example.calculator;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0018\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0019\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001a\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001c\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001d\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u001f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "},
        d2 = {"Lcom/example/calculator/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "display", "Landroid/widget/EditText;", "addB", "", "view", "Landroid/view/View;", "backspaceB", "clearB", "decimalB", "divideB", "eightB", "equalB", "expB", "fiveB", "fourB", "multiplyB", "nineB", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "oneB", "parB", "plusMinusB", "sevenB", "sixB", "subtractB", "threeB", "twoB", "zeroB", "Calculator.app"}
)
public final class MainActivity extends AppCompatActivity {
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);

        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd,rightStr));
        }
        display.setSelection(cursorPos+1);

    }

    public void zeroB(View view) {
        updateText("0");
    }

    public void oneB(View view) {
        updateText("1");
    }

    public void twoB(View view) {
        updateText("2");
    }

    public void threeB(View view) {
        updateText("3");
    }

    public void fourB(View view) {
        updateText("4");
    }

    public void fiveB(View view) {
        updateText("5");
    }

    public void sixB(View view) {
        updateText("6");
    }

    public void sevenB(View view) {
        updateText("7");
    }

    public void eightB(View view) {
        updateText("8");
    }

    public void nineB(View view) {
        updateText("9");
    }

    public void multiplyB(View view) {
        updateText("*");
    }

    public void subtractB(View view) {
        updateText("-");
    }

    public void addB(View view) {
        updateText("+");
    }

    public void divideB(View view) {
        updateText("÷");
    }

    public void clearB(View view) {
        display.setText("");
    }

    public void parB(View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closed = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++){
            if (display.getText().toString().substring(i, i + 1).equals("(")){
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i + 1).equals(")")){
                closed += 1;
            }
        }

        if (openPar == closed || display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText("(");
            display.setSelection(cursorPos+1);
        }
        else if (closed < openPar && !display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText(")");
            display.setSelection(cursorPos+1);
        }

    }

    public void expB(View view) {
        updateText("^");
    }

    public void equalB(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×","*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }

    public void plusMinusB(View view) {
        updateText("-");
    }

    public void decimalB(View view) {
        updateText(".");
    }

    public void backspaceB(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
}
