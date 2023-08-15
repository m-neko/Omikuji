package biz.mike_neko.omikuji;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OmikujiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omikuji);

        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.title);
        mediaPlayer.setVolume(1.0f,1.0f);
        mediaPlayer.start();

        ImageView ivOmikuji = findViewById(R.id.ivMain);
        OmikujiManager om = new OmikujiManager();
        Omikuji omikuji = om.getOmikuji();

        SharedPreferences prefs = getSharedPreferences("History", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String kuji = prefs.getString("Kuji","");

        Date date = new Date();
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy年MM月dd日");
        String strDate = sfd.format(date);

        if(omikuji == Omikuji.DAIKICHI){
            ivOmikuji.setImageResource(R.drawable.omikuji_daikichi);
            kuji = strDate + "　大吉," + kuji;
        }else if(omikuji == Omikuji.CHUUKICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_chuukichi);
            kuji = strDate + "　中吉," + kuji;
        }else if(omikuji == Omikuji.SYOKICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_syoukichi);
            kuji = strDate + "　小吉," + kuji;
        }else if(omikuji == Omikuji.KICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_kichi);
            kuji = strDate + "　吉," + kuji;
        }else if(omikuji == Omikuji.SUEKICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_suekichi);
            kuji = strDate + "　末吉," + kuji;
        }else if(omikuji == Omikuji.KYOU) {
            ivOmikuji.setImageResource(R.drawable.omikuji_kyou);
            kuji = strDate + "　凶," + kuji;
        }else{
            ivOmikuji.setImageResource(R.drawable.omikuji_daikyou);
            kuji = strDate + "　大凶," + kuji;
        }

        editor.putString("Kuji",kuji);
        editor.putString("Date",strDate);
        // editor.putString("Kuji","");
        editor.commit();
    }

    public void onClickBtnEnd(View v)
    {
        finish();
    }
}