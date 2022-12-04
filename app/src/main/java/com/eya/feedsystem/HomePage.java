package com.eya.feedsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    Button feed,cam;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_layout);



        feed = (Button) findViewById(R.id.btnfeed);
        cam = (Button) findViewById(R.id.btncam);

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(HomePage.this,feedingpage.class);
               startActivity(intent);
            }
        });
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,camPage.class);
                startActivity(intent);
            }
        });
    }
}
