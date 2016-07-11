package com.sibext.pavel.seaworld.world;

import android.util.Log;

public class Tux extends  Animal {

    private int reproductionTime = 0;

    public Tux(World world, int x, int y) {
        super(world, x, y);
    }

    @Override
    public void run() {
        Log.d("Tux","run");
        if(moved)
            return;

        move();
        reproductionTime++;
        if(reproductionTime >=3){
            reproductionTime=0;
            for (Route route : Route.values()) {
                if(checkEmpty(route)){
                    create(x+route.getX(),y+route.getY());
                    break;
                }
            }
        }

    }

    private void create(int x,int y){
        Log.d("Tux","create");
        field[y][x] = new Tux(world,x,y);
        ((Animal)field[y][x]).setMoved(true);
    }


}
