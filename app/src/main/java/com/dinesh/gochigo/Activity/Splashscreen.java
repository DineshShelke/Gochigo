package com.dinesh.gochigo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.dinesh.gochigo.MainActivity;
import com.dinesh.gochigo.R;

public class Splashscreen extends AppCompatActivity {

    RelativeLayout relativeLayout,relativeLayout2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            relativeLayout.setVisibility(View.VISIBLE);
//            relativeLayout2.setVisibility(View.VISIBLE);
            startActivity(new Intent(Splashscreen.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        relativeLayout = findViewById(R.id.really1);
        relativeLayout2 = findViewById(R.id.relativeLayout9);

        handler.postDelayed(runnable,2000);

    }
}
