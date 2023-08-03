package com.example.escapefromthecitynso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ImageView14 extends AppCompatActivity {
    // создание коллекции контейнера для класса Animal
    List<Animal> animals = new ArrayList<Animal>();
    private Button button; // поле кнопки назад
    // поля для звука
    Context context = this;
    MediaPlayer mp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view14);

        button = findViewById(R.id.button);
        // инициализируем контейнер
        setInitialData();

        // создадим объект  RecyclerView и привяжем к нему id
        RecyclerView recyclerView = findViewById(R.id.list_animal);

        // создадим адаптер и загрузим в него контейнер с данными
        Adapter adapter = new Adapter(this, animals);

        // на recyclerView поддадим адаптер
        recyclerView.setAdapter(adapter);

        mp = MediaPlayer.create(context, R.raw.ultra);

        // обработка нажатия кнопки назад
        button.setOnClickListener(listener);
    }
    // создание слушателя
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

            // переключение на другой экран
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class); // создание намерения переключения на другой экран
            intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT); // использование флага перемещения нужной активности на вершину стека
            startActivity(intent); // запуск дополнительной активности через намерение
        }
    };

    // метод setInitialData() устанавливает начальный набор данных(а именно изображения из папки res/drawable)
    private void setInitialData() {
        // добавление в контейнер animals оъектов сущности Animal
        animals.add(new Animal("  Гранитные обрывы на берегу реки Бердь известны местным жителям давно, а первые туристы появились здесь полвека назад. Центральная (самая высокая) скала получила название «Зверобой»: с ее вершины можно было отстреливать диких животных. По геологическому происхождению Бердский обрыв является обнажением кристаллических палеозойских пород на востоке Приобского плато. По руслу реки Бердь скалы граничат с западным краем Присалаирской равнины. Гранитные выходы на Берди отличаются:\n" +

                 "  высотой — до 300 метров;\n" +
                 "  протяженностью вдоль реки — 1300 метров;\n" +
                 "  крутизной стен — на отдельных участках достигает 80 градусов, поэтому опасна для неподготовленных туристов.\n" +
                 "  Еще одной особенностью обрывов является курумник — так называют крупные осыпи из остроконечных валунов, которые характерны для горных районов Алтая. В Новосибирской области увидеть его можно только у излучины Берди.", R.drawable.dsc_0379,R.drawable.dsc_0362,R.drawable.dsc_0389));
    }
}