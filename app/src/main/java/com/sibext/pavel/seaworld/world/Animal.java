package com.sibext.pavel.seaworld.world;

import android.util.Log;

import com.sibext.pavel.seaworld.MyRandom;

public abstract class Animal implements Cell {
    protected int x,y;
    protected Cell [][] field;
    protected World world;
    protected boolean moved = false;
    public Animal(World world,int x,int y){
        this.world = world;
        field = world.getField();
        this.x = x;
        this.y= y;
    }
    protected void move(){
        Log.d("Animal","move");
        if(moved)
            return;
        int route = MyRandom.generateRandom(1,8);
        int x1=x,y1=y;
        switch (route){
            case 1:
                x1 = x-1;
                break;
            case 2:
                x1=x-1;
                y1=y-1;
                break;
            case 3:
                y1=y-1;
                break;
            case 4:
                x1=x+1;
                y1=y-1;
                break;
            case 5:
                x1=x+1;
                break;
            case 6:
                x1=x+1;
                y1=y+1;
                break;
            case 7:
                y1=y+1;
                break;
            case 8:
                x1=x-1;
                y1=y+1;
                break;
        }


        if(x1 > -1 && x1<world.getWidth() && y1> -1 && y1<world.getHeight() && field[y1][x1] instanceof EmptyCell){
            moveTo(x1,y1);
        }
        moved = true;
    }
    protected void moveTo(int x1,int y1){
        Log.d("Animal","moveTo");
        field[y1][x1] = field[y][x];
        field[y][x] = new EmptyCell();
        y=y1;
        x =x1;
    }
    protected boolean checkEmpty(Route route){
        int x = route.getX()+this.x;
        int y = route.getY()+this.y;
        if(x > -1 && x < world.getWidth() && y > -1 && y < world.getHeight() && field[y][x] instanceof  EmptyCell){
            return true;
        }else
            return false;
    }
    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public abstract void run();


}
