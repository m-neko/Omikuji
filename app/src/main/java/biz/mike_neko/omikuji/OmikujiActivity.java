package biz.mike_neko.omikuji;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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

        if(omikuji == Omikuji.DAIKICHI){
            ivOmikuji.setImageResource(R.drawable.omikuji_daikichi);
        }else if(omikuji == Omikuji.CHUUKICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_chuukichi);
        }else if(omikuji == Omikuji.SYOKICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_syoukichi);
        }else if(omikuji == Omikuji.KICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_kichi);
        }else if(omikuji == Omikuji.SUEKICHI) {
            ivOmikuji.setImageResource(R.drawable.omikuji_suekichi);
        }else if(omikuji == Omikuji.KYOU) {
            ivOmikuji.setImageResource(R.drawable.omikuji_kyou);
        }else{
            ivOmikuji.setImageResource(R.drawable.omikuji_daikyou);
        }
    }

    public void onClickBtnEnd(View v){
        finish();
    }
}