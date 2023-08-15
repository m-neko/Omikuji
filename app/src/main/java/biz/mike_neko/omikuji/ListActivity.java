package biz.mike_neko.omikuji;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button btnRev = findViewById(R.id.BtnRev);
        btnRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SharedPreferences prefs = getSharedPreferences("History", Activity.MODE_PRIVATE);
        String kuji = prefs.getString("Kuji","");

        ListView lvHistory = findViewById(R.id.lvHistory);
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(kuji.split(",")));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1,list);
        lvHistory.setAdapter(adapter);
    }

}