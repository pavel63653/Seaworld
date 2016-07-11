package com.sibext.pavel.seaworld.world;

 enum Route {
     LEFT(-1,0),LEFTTOP(-1,-1),TOP(0,-1),RIGHTTOP(1,-1),RIGHT(1,0),RIGHTBOTTOM(1,1),BOTTOM(0,1),LEFTBOTTOM(-1,1);
     private int x,y;
     Route(int x,int y){
         this.x = x;
         this.y = y;
     }

     public int getX() {
         return x;
     }

     public int getY() {
         return y;
     }
 }
