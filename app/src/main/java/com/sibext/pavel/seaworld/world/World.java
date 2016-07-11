package com.sibext.pavel.seaworld.world;

import android.util.Log;

import com.sibext.pavel.seaworld.Controller;
import com.sibext.pavel.seaworld.MyRandom;

public class World {
    private Controller controller;
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
                if(field[i][y] instanceof Animal){
                    ((Animal)field[i][y]).run();;
                }
            }
        }
        for(int i = 0;i < height;i++){
            for(int y =0;y < width;y++) {
                if(field[i][y] instanceof Animal){
                    ((Animal)field[i][y]).setMoved(false);
                }
            }
        }
        if(controller != null)
            controller.show();


    }
    public void initialize(){
        field = new Cell[height][width];
        int numberOrca = size*5/100;
        int numberTux = size/2;

        for(int i = 0;i < height;i++){
            for(int y =0;y < width;y++){
                if(numberOrca > 0){
                    field[i][y] = new Orca(this,y,i);
                    numberOrca--;
                }else{
                    if(numberTux > 0) {
                        field[i][y] = new Tux(this,y,i);
                        numberTux--;
                    }else{
                        field[i][y] = new EmptyCell();

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
        if(controller != null)
            controller.show();
    }
    Cell [][] getField(){
        return field;
    }

    public int getCell(int y,int x){
        if(field[y][x] instanceof Orca){
            return ORCA;
        }else{
            if(field[y][x] instanceof Tux) {
                return TUX;
            }else
                if(field[y][x] instanceof EmptyCell)
                    return EMPTY;
            else return -1;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private void swap(int x1,int y1,int x2,int y2) {
        Cell cell = field[y1][x1];
        field[y1][x1] = field[y2][x2];
        field[y2][x2] = cell;
        if (field[y1][x1] instanceof Animal) {
            ((Animal) field[y1][x1]).x = x1;
            ((Animal) field[y1][x1]).y = y1;
        }
        if (field[y2][x2] instanceof Animal) {
            ((Animal) field[y2][x2]).x = x2;
            ((Animal) field[y2][x2]).y = y2;
        }

    }

}
