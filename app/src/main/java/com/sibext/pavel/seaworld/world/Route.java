package com.sibext.pavel.seaworld.world;

import com.sibext.pavel.seaworld.MyRandom;

enum Route {
     LEFT(-1,0),LEFTTOP(-1,-1),TOP(0,-1),RIGHTTOP(1,-1),RIGHT(1,0),RIGHTBOTTOM(1,1),BOTTOM(0,1),LEFTBOTTOM(-1,1);
     private int x,y;
     Route(int x,int y){
         this.x = x;
         this.y = y;
     }
     public static Route getRandomRoute(){
         int value = MyRandom.generateRandom(1,8);
         switch (value){
             case 1:
                 return LEFT;
             case 2:
                 return LEFTTOP;
             case 3:
                 return TOP;
             case 4:
                 return RIGHTTOP;
             case 5:
                 return RIGHT;
             case 6:
                 return RIGHTBOTTOM;
             case 7:
                 return BOTTOM;
             case 8:
                 return LEFTBOTTOM;
             default:
                 return null;
         }

     }

     public int getX() {
         return x;
     }

     public int getY() {
         return y;
     }
 }
