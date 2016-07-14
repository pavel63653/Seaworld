package com.sibext.pavel.seaworld.world;

import android.util.Log;

import com.sibext.pavel.seaworld.MyRandom;

public abstract class Animal {
    protected int x,y;
    protected Cell [][] field;
    protected World world;
    protected boolean moved = false;
    Animal(World world,int x,int y){
        this.world = world;
        field = world.getField();
        this.x = x;
        this.y= y;
    }
    protected void move(){
        Log.d("Animal","move");
        if(moved)
            return;
        Route route = Route.getRandomRoute();
        if(checkEmpty(route)){
            int x1 = route.getX()+x;
            int y1 = route.getY()+y;
            moveTo(x1,y1);
        }
        moved = true;
    }
    protected void moveTo(int x1,int y1){
        Log.d("Animal","moveTo");
        field[y1][x1].setAnimal(this);
        field[y][x].setAnimal(null);
        y=y1;
        x =x1;
    }
    protected boolean checkEmpty(Route route){
        int x = route.getX()+this.x;
        int y = route.getY()+this.y;
        if(x > -1 && x < world.getWidth() && y > -1 && y < world.getHeight() && field[y][x].getAnimal() == null){
            return true;
        }else
            return false;
    }
    boolean isMoved() {
        return moved;
    }

    void setMoved(boolean moved) {
        this.moved = moved;
    }

    abstract void run();
    void nextTurn(){
        moved = false;
    }
    boolean isEatable(){
        return false;
    }
    public abstract int getImage();

}
