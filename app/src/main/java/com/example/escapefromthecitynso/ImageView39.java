package com.example.escapefromthecitynso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ImageView39 extends AppCompatActivity {
    // создание коллекции контейнера для класса Animal
    List<Animal> animals = new ArrayList<Animal>();
    private Button button; // поле кнопки назад
    // поля для звука
    Context context = this;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view39);

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
        animals.add(new Animal("  Гора «Соколиный камень» высотой 227 м возвышается прямо над Бердью. В этом месте река делает крутой поворот, оставляя песчаный пляж.\n" +
                "\n" +
                "  До начала 1960 г. это был отвесный утес. Русло реки Бердь было ближе к горе и глубже до 10 метров. По рассказам местного старожила Барсукова С.И. на горе жил сокол, которого убили в начале XX в. \n" +
                "\n" +
                "  В 1966 г. гора была взорвана для получения строительного камня. Изменился ее вид, русло Берди стало мельче, исчезла глубина. \n" +
                "\n" +
                "  Название горы связано с добычей строительного камня и легендой о соколе. «Соколиный камень» – прекрасное место для стоянки, можно совершить восхождение и любоваться панорамой местности. Но нужно быть осторожнее, так как на горе много гадюк. В теплую погоду они вылезают погреться на солнце, поэтому туристам необходимо позаботиться о хорошей обуви и плотных брюках. Обычная гадюка не в состоянии прокусить джинсы.", R.drawable.dsc_0259,R.drawable.dsc_0241,R.drawable.dsc_0320));
    }
}