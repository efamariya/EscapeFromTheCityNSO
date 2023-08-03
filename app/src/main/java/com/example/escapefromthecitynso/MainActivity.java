package com.example.escapefromthecitynso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView3;

    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(context, R.raw.ultra);
        // присваевание id полям
        imageView3 = findViewById(R.id.imageView3);

        // обработка нажатия на кнопки
        imageView3.setOnClickListener(listener);
    }

    // создадим слушателя кнопки нажатия
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // звук на кнопку
            try {
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(context, R.raw.ultra);
                } mp.start();
            } catch(Exception e) { e.printStackTrace(); }

            // переключение на новую активность
            Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
            startActivity(intent);
        }
    };
}