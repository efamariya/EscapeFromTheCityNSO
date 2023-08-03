package com.example.escapefromthecitynso;

public class Animal {
    private String discription; // поле описания места
    private int animalResourse,animalResourse2,animalResourse3; // поле ресурса фото

    // конструктор

    public Animal(String discription, int animalResourse, int animalResourse2, int animalResourse3) {
        this.discription = discription;
        this.animalResourse = animalResourse;
        this.animalResourse2 = animalResourse2;
        this.animalResourse3 = animalResourse3;
    }


    // геттеры и сеттеры

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getAnimalResourse() {
        return animalResourse;
    }

    public void setAnimalResourse(int animalResourse) {
        this.animalResourse = animalResourse;
    }

    public int getAnimalResourse2() {
        return animalResourse2;
    }

    public void setAnimalResourse2(int animalResourse2) {
        this.animalResourse2 = animalResourse2;
    }

    public int getAnimalResourse3() {
        return animalResourse3;
    }

    public void setAnimalResourse3(int nimalResourse3) {
        this.animalResourse3 = nimalResourse3;
    }
}
