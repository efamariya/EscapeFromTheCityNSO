package com.example.escapefromthecitynso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    // поля кнопок с названиями мест
    private ImageView imageView9; // барсуковская пещера
    private ImageView imageView13; // беловский водопад
    private ImageView imageView14; // бердские скалы
    private ImageView imageView15; // березовские скалы
    private ImageView imageView29; // бурановский водопад
    private ImageView imageView30; // водопад бучило
    private ImageView imageView31; // гычевские скалы
    private ImageView imageView32; // дебаркадер
    private ImageView imageView33; // искитимский мраморный карьер
    private ImageView imageView34; // пещеры егорьевская и колючая
    private ImageView imageView35; // речкуновский заброшенный санаторий
    private ImageView imageView36; // серебренниковский мраморный карьер
    private ImageView imageView37; // скала альпинист
    private ImageView imageView38; // скала собачий камень
    private ImageView imageView39; // скала соколиный камень
    private ImageView imageView40; // суенгинский водопад
    Context context = this;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // присваевание id полям
        imageView9 = findViewById(R.id.imageView9);
        // присваевание id полям
        imageView13 = findViewById(R.id.imageView13);
        // присваевание id полям
        imageView14 = findViewById(R.id.imageView14);
        // присваевание id полям
        imageView15 = findViewById(R.id.imageView15);
        // присваевание id полям
        imageView29 = findViewById(R.id.imageView29);
        // присваевание id полям
        imageView30 = findViewById(R.id.imageView30);
        // присваевание id полям
        imageView31 = findViewById(R.id.imageView31);
        // присваевание id полям
        imageView32 = findViewById(R.id.imageView32);
        // присваевание id полям
        imageView33 = findViewById(R.id.imageView33);
        // присваевание id полям
        imageView34 = findViewById(R.id.imageView34);
        // присваевание id полям
        imageView35 = findViewById(R.id.imageView35);
        // присваевание id полям
        imageView36 = findViewById(R.id.imageView36);
        // присваевание id полям
        imageView37 = findViewById(R.id.imageView37);
        // присваевание id полям
        imageView38 = findViewById(R.id.imageView38);
        // присваевание id полям
        imageView39 = findViewById(R.id.imageView39);
        // присваевание id полям
        imageView40 = findViewById(R.id.imageView40);

        // обработка нажатия на кнопки
        imageView9.setOnClickListener(listener);
        imageView13.setOnClickListener(listener);
        imageView14.setOnClickListener(listener);
        imageView15.setOnClickListener(listener);
        imageView29.setOnClickListener(listener);
        imageView30.setOnClickListener(listener);
        imageView31.setOnClickListener(listener);
        imageView32.setOnClickListener(listener);
        imageView33.setOnClickListener(listener);
        imageView34.setOnClickListener(listener);
        imageView35.setOnClickListener(listener);
        imageView36.setOnClickListener(listener);
        imageView37.setOnClickListener(listener);
        imageView38.setOnClickListener(listener);
        imageView39.setOnClickListener(listener);
        imageView40.setOnClickListener(listener);

        mp = MediaPlayer.create(context, R.raw.ultra);
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
            switch (view.getId()) {
                case R.id.imageView9:
                    Intent intentImageView9 = new Intent(getApplicationContext(), ImageView9.class);
                    intentImageView9.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // использование флага перехода к нужной активности
                    startActivity(intentImageView9);
                    break;
                case R.id.imageView13:
                    Intent intentImageView13 = new Intent(getApplicationContext(), ImageView13.class);
                    intentImageView13.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView13);
                    break;
                case R.id.imageView14:
                    Intent intentImageView14 = new Intent(getApplicationContext(), ImageView14.class);
                    intentImageView14.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView14);
                    break;
                case R.id.imageView15:
                    Intent intentImageView15 = new Intent(getApplicationContext(), ImageView15.class);
                    intentImageView15.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView15);
                    break;
                case R.id.imageView29:
                    Intent intentImageView29 = new Intent(getApplicationContext(), ImageView29.class);
                    intentImageView29.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView29);
                    break;
                case R.id.imageView30:
                    Intent intentImageView30 = new Intent(getApplicationContext(), ImageView30.class);
                    intentImageView30.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView30);
                    break;
                case R.id.imageView31:
                    Intent intentImageView31 = new Intent(getApplicationContext(), ImageView31.class);
                    intentImageView31.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView31);
                    break;
                case R.id.imageView32:
                    Intent intentImageView32 = new Intent(getApplicationContext(), ImageView32.class);
                    intentImageView32.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView32);
                    break;
                case R.id.imageView33:
                    Intent intentImageView33 = new Intent(getApplicationContext(), ImageView33.class);
                    intentImageView33.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView33);
                    break;
                case R.id.imageView34:
                    Intent intentImageView34 = new Intent(getApplicationContext(), ImageView34.class);
                    intentImageView34.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView34);
                    break;
                case R.id.imageView35:
                    Intent intentImageView35 = new Intent(getApplicationContext(), ImageView35.class);
                    intentImageView35.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView35);
                    break;
                case R.id.imageView36:
                    Intent intentImageView36 = new Intent(getApplicationContext(), ImageView36.class);
                    intentImageView36.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView36);
                    break;
                case R.id.imageView37:
                    Intent intentImageView37 = new Intent(getApplicationContext(), ImageView37.class);
                    intentImageView37.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView37);
                    break;
                case R.id.imageView38:
                    Intent intentImageView38 = new Intent(getApplicationContext(), ImageView38.class);
                    intentImageView38.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView38);
                    break;
                case R.id.imageView39:
                    Intent intentImageView39 = new Intent(getApplicationContext(), ImageView39.class);
                    intentImageView39.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView39);
                    break;
                case R.id.imageView40:
                    Intent intentImageView40 = new Intent(getApplicationContext(), ImageView40.class);
                    intentImageView40.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intentImageView40);
            }
        }
    };
}
