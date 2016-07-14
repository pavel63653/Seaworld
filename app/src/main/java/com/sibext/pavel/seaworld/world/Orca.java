package com.sibext.pavel.seaworld.world;

import android.util.Log;

import com.sibext.pavel.seaworld.R;

public class Orca extends Animal {
    private final int MAXLIFETIME = 3;
    private final int MAXREPRODUCTIONTIME = 8;
    private int reproductionTime = 0;
    private int lifetime = 0;
    Orca(World world, int x, int y) {
        super(world, x, y);
    }

    @Override
     void run() {
        Log.d("Orca","run");
        if(moved)
            return;
        reproductionTime++;
        lifetime++;
        for (Route route : Route.values()) {
            if(checkTux(route)){
                lifetime =0;
                moveTo(x+route.getX(),y+route.getY());
                moved = true;
                break;
            }
        }
        if(lifetime >= MAXLIFETIME){
            field[y][x].setAnimal(null);
            return;
        }
        if(!moved)
          move();
        if(reproductionTime >=MAXREPRODUCTIONTIME){
            reproductionTime=0;
            for (Route route : Route.values()) {
                if(checkEmpty(route)){
                    create(x+route.getX(),y+route.getY());
                    break;
                }
            }
        }
    }

    @Override
    public int getImage() {
        return R.drawable.orca;
    }

    private boolean checkTux(Route route){
        int x = route.getX()+this.x;
        int y = route.getY()+this.y;
        if(x > -1 && x < world.getWidth() && y > -1 && y < world.getHeight() && field[y][x].getAnimal() != null && field[y][x].getAnimal().isEatable()){
            return true;
        }else
            return false;
    }
    private void create(int x,int y){
        Log.d("Orca","create");
        Orca orca = new Orca(world,x,y);
        orca.setMoved(true);
        field[y][x].setAnimal(orca);

    }


}
