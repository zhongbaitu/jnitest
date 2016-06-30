package com.baitu.jnitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.add_a)
    EditText mAddA;
    @Bind(R.id.add_b)
    EditText mAddB;
    @Bind(R.id.add_result)
    TextView mAddResult;
    @Bind(R.id.sub_a)
    EditText mSubA;
    @Bind(R.id.sub_b)
    EditText mSubB;
    @Bind(R.id.sub_result)
    TextView mSubResult;
    @Bind(R.id.add_btn)
    TextView mAddBtn;
    @Bind(R.id.sub_btn)
    TextView mSubBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        int result = CalculatorHelper.add(1, 2);
        Toast.makeText(this, "result:" + result, Toast.LENGTH_LONG).show();
//        textView.setText(get());
//
//        set("hello 哈哈哈哈哈哈哈 ~~~");
    }

    @OnClick({R.id.add_btn, R.id.sub_btn})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                add();
                break;

            case R.id.sub_btn:
                sub();
                break;
        }
    }

    private void add() {
        String aStr = mAddA.getText().toString();
        String bStr = mAddB.getText().toString();
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int result = CalculatorHelper.add(a, b);
        mAddResult.setText(String.valueOf(result));
    }

    private void sub() {
        String aStr = mSubA.getText().toString();
        String bStr = mSubB.getText().toString();
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int result = CalculatorHelper.sub(a, b);
        mSubResult.setText(String.valueOf(result));
    }

    public static void callByJni(String str) {
        Log.v("test_jni", "hello" + str);
    }

//    public native String get();
//    public native void set(String str);

}
