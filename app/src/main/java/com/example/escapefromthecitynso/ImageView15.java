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

public class ImageView15 extends AppCompatActivity {
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
        setContentView(R.layout.activity_image_view15);

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
        animals.add(new Animal("  О Зверобое слышали многие. Но есть (относительно недалеко от него) другая достопримечательность, которая тоже находится на реке Бердь. Это Берёзовские скалы. Они примерно в восьми километрах от села Берёзово (Маслянинский район). Березовские скалы представляют собой серию очень живописных скальных выступов. На одном из них постоянно тренируются и соревнуются скалолазы. Тут несколько вертикальных трасс различной сложности, на которых проводят фестивали и чемпионаты нашего региона по альпинизму. И здесь же мастерство горной подготовки оттачивают новосибирские спасатели. Высота некоторых утёсов достигает 50 метров!\n" +
                "\n" +
                "  Будьте осторожны - здесь встречается щитомордник обыкновенный – редкая у нас змея, занесенная в Красную книгу Новосибирской области. Щитомордник – это родственник американской гремучей змеи. У него на конце хвоста есть рудиментарная погремушка, которой он трясет, будучи потревоженным.", R.drawable.dsc_0294,R.drawable.dsc_0298,R.drawable.dsc_0332));
    }
}