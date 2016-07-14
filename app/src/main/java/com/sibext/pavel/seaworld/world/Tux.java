package com.sibext.pavel.seaworld.world;

import android.util.Log;

import com.sibext.pavel.seaworld.R;

public class Tux extends  Animal {

    private int reproductionTime = 0;

    Tux(World world, int x, int y) {
        super(world, x, y);
    }

    @Override
    void run() {
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
    boolean isEatable(){
        return true;
    }

    @Override
    public int getImage() {
        return R.drawable.tux;
    }

    private void create(int x,int y){
        Log.d("Tux","create");
        Tux tux = new Tux(world,x,y);
        field[y][x].setAnimal(tux);
        tux.setMoved(true);
    }


}
