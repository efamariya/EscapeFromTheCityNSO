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

public class ImageView34 extends AppCompatActivity {
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
        setContentView(R.layout.activity_image_view34);
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
        animals.add(new Animal("  Не смотря на кажущуюся простоту, обе эти пещеры не рекомендуются для посещения неподготовленными группами туристов. \n" +
                "\n" +
                "  _Пещера Колючая._\n" +
                "\n" +
                "  Протяженность 29м, глубина 23м. \n" +
                "  Пещера представляет собой почти вертикальный колодец глубиной 20 метров. \n" +
                "  В июне 2000 года был поднят камень, преграждавший ход на глубине 9 метров. Члены скаутского отряда «Сталкер» Драчкова Ирина и Макаров Александр спустились на дно колодца. Пещера представляла 20-21 метровый колодец на дне которого была узкая щель, после которой пещера продолжалась. Ирина с Александром пытались прокопать ход, но во время этой экспедиции дальше проникнуть не удалось. Предполагаемый резерв высоты (до уровня реки Суенги) около 10 метров. \n" +
                " \n" +
                "  Егорьевская пещера \n" +
                " \n" +
                "  Пещера на сегодня на первом месте по протяжённости среди пещер Новосибирской области и на втором – на Салаирском кряже. \n" +
                "  Глубиной около 35 метров с большим количеством не длинных проходов. Имеет протяженность около 200 метров. \n" +
                "  Сама пещера очень не гостеприимна, неподготовленным туда лучше не попадать. Например, в начале ноября 2010 одному туристу пришлось провести в пещере 12 часов, пока его не извлекли специалисты МЧС.", R.drawable.dsc_0084,R.drawable.dsc_0112,R.drawable.dsc_0115));
    }
}