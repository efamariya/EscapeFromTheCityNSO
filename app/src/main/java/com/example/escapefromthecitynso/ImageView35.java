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

public class ImageView35 extends AppCompatActivity {
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
        setContentView(R.layout.activity_image_view35);
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
        animals.add(new Animal("  Советский санаторий, заброшенный с 2004 года. Расположен на берегу Бердского залива, в «Речкуновской зоне отдыха».\n" +
                "  Был построен в 1959 году и по праву считался одной из лучших кардиологических здравниц страны. Вначале был рассчитан на 200 коек, к 1989 году — на 700. Ежегодно здесь проходили лечение около 10 000 человек. В «Речкуновке» успешно лечили гипертонию, кардиосклероз, коронаросклероз, неврастению и другие заболевания. Путёвками в санаторий награждали лучших работников хозяйства и промышленности СССР, самостоятельно бронировать весьма не дешёвые путёвки приходилось за целый сезон.\n" +
                "\n" +
                "  26 сентября 2004 года всем сотрудникам и отдыхающим было официально объявлено о закрытии «Речкуновского» санатория. С сентября 2004 года официально не функционирует. Официальная причина закрытия — банкротство. Изначально территория была «законсервирована», стояла будка охраны. Летом 2005 года территория была уже не «законсервирована» и не охранялась. Рядом расположены санаторий «Сосновка» (с левой стороны, относительно «Речкуновского» санатория) и частная, хорошо охраняемая территория (бывшая общедоступная база отдыха) «Сибиряк».", R.drawable.dsc_0630,R.drawable.dsc_0845,R.drawable.dsc_0896));
    }
}