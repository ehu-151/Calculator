package org.t_robop.matsu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //一時保存
    int temp = 0;
    //a+b,a-bなど
    int a = 0, b = 0;
    //計算結果
    int sum;
    //記号を判断する
    int mark_Check = 0;

    //一番上の数字を表示するところ
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView)findViewById(R.id.resultText);
    }

    //数字をクリックした時
    public void numClick(View v){
        //タグを文字列に変換
        String num = String.valueOf(v.getTag());
        //文字列をintへ変換させる
        temp = Integer.parseInt(num);

        //TextViewにtempの値を反映させる
        resultText.setText(num);
    }

    //記号をクリックした時
    public void markClick(View v){
        //タグを文字列に変換
        String num = String.valueOf(v.getTag());
        //文字列をintへ変換させる…0:足し算 1:引き算 2:掛け算 3:割り算
        mark_Check = Integer.parseInt(num);

        //tempの値をaに代入する
        a = temp;
        //tempの初期化
        temp = 0;
    }

    //=をクリックした時
    public void equalClick(View v){
        //tempの値をbに代入する
        b = temp;
        //tempの初期化
        temp = 0;
        //mark_Checkに対応した四則演算をさせる
        switch (mark_Check){
            case 0:
                sum = a + b;
                break;
            case 1:
                sum = a - b;
                break;
            case 2:
                sum = a * b;
                break;
            case 3:
                sum = a / b;
                break;
            default:
                break;
        }
        //sumの値をresultTextに表示させる
        resultText.setText(String.valueOf(sum));
    }
}
