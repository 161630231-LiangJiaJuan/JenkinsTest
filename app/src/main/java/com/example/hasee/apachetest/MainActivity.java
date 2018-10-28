package com.example.hasee.apachetest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class MainActivity extends Activity {
    private TextView tv_output0,tv_output1,tv_output2;
    private EditText et_input0,et_input1,et_input1_2,et_num0,et_num1;
    private Button btn_confirm0,btn_confirm1,btn_confirm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
    }

    private void InitView() {
        tv_output0=findViewById(R.id.tv_output0);
        et_input0=findViewById(R.id.et_input0);
        btn_confirm0=findViewById(R.id.btn_confirm0);

        btn_confirm0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_output0.setText(reverseStr(et_input0.getText().toString()));
                hideKeyBoard(btn_confirm0);
            }
        });

        tv_output1=findViewById(R.id.tv_output1);
        et_input1=findViewById(R.id.et_input1);
        et_input1_2=findViewById(R.id.et_input1_2);
        btn_confirm1=findViewById(R.id.btn_confirm1);

        btn_confirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_output1.setText(repeatStr(et_input1.getText().toString(),NumberUtils.createInteger(et_input1_2.getText().toString())));
                hideKeyBoard(btn_confirm1);
            }
        });

        tv_output2=findViewById(R.id.tv_output2);
        et_num0=findViewById(R.id.et_num0);
        et_num1=findViewById(R.id.et_num1);
        btn_confirm2=findViewById(R.id.btn_confirm2);
        btn_confirm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str0=et_num0.getText().toString();
                String str1=et_num1.getText().toString();
                Integer num0=creatNum(str0);
                Integer num1=creatNum(str1);
                tv_output2.setText(compareNum(num0,num1));
                hideKeyBoard(btn_confirm2);
            }
        });
    }

    protected String repeatStr(String s,int count) {
        if(NumberUtils.isDigits(String.valueOf(count))){
            return  s;
        }
        if (StringUtils.isEmpty(s)){
            return s;
        }
        return StringUtils.repeat(s,count);
    }

    protected String reverseStr(String s) {
        if (StringUtils.isEmpty(s)) return  s;
        if (StringUtils.indexOfIgnoreCase(s," ")!=-1){
            return StringUtils.reverseDelimited(s,' ');
        }
        return StringUtils.reverse(s);
    }

    protected Integer creatNum(String s){
        if (StringUtils.isEmpty(s)){
            return 0;
        }
        else if (!StringUtils.isNumeric(s)){
            return  0;
        }
        else {
            return NumberUtils.createInteger(s);
        }
    }

    protected String compareNum(int num0,int num1){
        switch (NumberUtils.compare(num0,num1)){
            case 1: return "相同";
            case -1: return  "第一个数字大于第二个数字";
            case 0:return  "第一个数字小于第二个数字";
            default: return "null";
        }
    }

    protected void hideKeyBoard(View view){
        InputMethodManager imm=(InputMethodManager)view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm!=null){
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }

    }


}
