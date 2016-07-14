package com.sibext.pavel.seaworld.world;

import com.sibext.pavel.seaworld.MyRandom;

public class World {
    public static final int ORCA =1;
    public static final int TUX =2;
    public static final int EMPTY =0;
    private int height,width,size;
    private Cell[][] field;
    public World(int height,int width){
        this.height = height;
        this.width = width;
        size = height*width;
        initialize();
    }

    public void run(){
        for(int i = 0;i < height;i++){
            for(int y =0;y < width;y++){
                field[i][y].run();
            }
        }
        for(int i = 0;i < height;i++){
            for(int y =0;y < width;y++) {
                field[i][y].nextTurn();
            }
        }
    }
    public void initialize(){
        field = new Cell[height][width];
        int numberOrca = size*5/100;
        int numberTux = size/2;

        for(int i = 0;i < height;i++){
            for(int y =0;y < width;y++){
                field[i][y] = new Cell();
                if(numberOrca > 0){
                    field[i][y].setAnimal(new Orca(this,y,i));
                    numberOrca--;
                }else{
                    if(numberTux > 0) {
                        field[i][y].setAnimal(new Tux(this,y,i));
                        numberTux--;
                    }
                }
            }
        }
        for(int i = 0;i < height;i++) {
            for (int y = 0; y < width; y++) {
                int  x0 =  MyRandom.generateRandom(0,width-1);
                int  y0 =  MyRandom.generateRandom(0,height-1);
                swap(y,i,x0,y0);
            }
        }

    }
    Cell [][] getField(){
        return field;
    }

    public Animal getAnimal(int x,int y){
        return field[y][x].getAnimal();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private void swap(int x1,int y1,int x2,int y2) {

        Animal animal1 = field[y1][x1].getAnimal();
        Animal animal2 = field[y2][x2].getAnimal();
        field[y1][x1].setAnimal(animal2);
        field[y2][x2].setAnimal(animal1);
        if(animal2 != null){
            animal2.x = x1;
            animal2.y = y1;
        }
        if(animal1 != null){
            animal1.x = x2;
            animal1.y = y2;
        }

    }

}
