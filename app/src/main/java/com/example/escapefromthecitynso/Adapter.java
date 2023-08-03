package com.example.escapefromthecitynso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    // неизменяемые поля адаптера
    private final LayoutInflater inflater; // поле для трансформации Layout-файла в View-элемент
    private final List<Animal> animals; // поле коллекции контейнера для хранения данных(оъектов класса Animal)

    // конструктор адаптера


    public Adapter(Context context, List<Animal> animals) {
        this.inflater = LayoutInflater.from(context);
        this.animals = animals;
    }
    // метод onCreateViewHolder() возвращает объекты ViewHolder(), который будет хранить данные по одному оъекту Animal
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false); // трансформация layout-файла в View-элемент
        return new ViewHolder(view);
    }
    // метод onBindViewHolder() выполняет привязку объекта ViewHolder(), который будет хранить данные по одному оъекту Animal
    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.imageView.setImageResource(animal.getAnimalResourse());
        holder.imageView6.setImageResource(animal.getAnimalResourse2());
        holder.imageView7.setImageResource(animal.getAnimalResourse3());
        holder.textView4.setText(animal.getDiscription());
    }

    // метод getItemCount() возращает количество объектов в списке
    @Override
    public int getItemCount() {
        return animals.size();
    }

    // созданный статический класс ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // неизменяемые поля представления
        final ImageView imageView;
        final ImageView imageView6;
        final ImageView imageView7;
        final TextView textView4;

        // конструктор класса ViewHolder с помощью которого мы связываем поля и представление list_item.xml
        ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            imageView6 = view.findViewById(R.id.imageView6);
            imageView7 = view.findViewById(R.id.imageView7);
            textView4 = view.findViewById(R.id.textView4);
        }
    }
}
