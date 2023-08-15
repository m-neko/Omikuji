package biz.mike_neko.omikuji;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);

        SharedPreferences prefs = getSharedPreferences("History", Activity.MODE_PRIVATE);
        String prefDate = prefs.getString("Date","");
        Date date = new Date();
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy年MM月dd日");
        String currentDate = sfd.format(date);

        // 前回引いた日が今日であれば明日までくじを引けない
        if(prefDate.equals(currentDate)){
            btnStart.setEnabled(false);
        }
    }

    // 「おみくじを引く」ボタン
    public void onClickBtnStart(View v){
        Intent intent = new Intent(getApplicationContext(),OmikujiActivity.class);
        startActivity(intent);
        finish();
    }

    // 「これまでの運勢」ボタン
    public void onClickBtnHistory(View v){
        Intent intent = new Intent(getApplicationContext(),ListActivity.class);
        startActivity(intent);
    }
}