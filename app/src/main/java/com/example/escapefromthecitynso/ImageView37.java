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

public class ImageView37 extends AppCompatActivity {

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
        setContentView(R.layout.activity_image_view37);

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
        animals.add(new Animal("  Альпинист - один из первых крупных скальных выходов вверх по течению реки, представляет собой участок склона в долину реки Бердь со скальным выходом к урезу воды. Нижней границей участка служит река Бердь, на песчаных аллювиальных наносах которой произрастают разнотравно-канареечные луга. На вершине скалы расположены реликтовые для современной растительности степные сообщества, прослеживается высотная поясность. Сам скальный выступ обеспечивает существование необычного сочетания растительных сообществ. Полынно-мятликовые, каменистые, ковыльно-кустарниковые, сообщества растений прекрасно себя чувствуют на этом участке. Скала представляет собой уголок уникального биогеоценоза, где наблюдается сочетание лесных, речных и горных экосистем на площади чрезвычайно небольшого размера. Значимость объекта заключается в том, что он практически не имеет аналогов и представляет собой уникальный элемент ландшафта по возможностям его комплексного использования для научно-исследовательских, эколого-просветительских, рекреационных целей. Абсолютная высота: 171 метр над уровнем моря. Относительная высота: 71 метр.", R.drawable.dsc_0315,R.drawable.dsc_0296,R.drawable.dsc_0301));
    }
}