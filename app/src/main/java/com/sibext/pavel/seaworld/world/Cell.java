package com.sibext.pavel.seaworld.world;

public class Cell {
    private Animal animal;
    public void run(){
        if(animal != null)
            animal.run();
    }
    public void nextTurn(){
        if(animal != null)
            animal.nextTurn();
    }
    public void setAnimal(Animal animal){
        this.animal =animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
