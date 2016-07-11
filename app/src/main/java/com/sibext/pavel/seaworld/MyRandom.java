package com.sibext.pavel.seaworld;

import android.util.Log;

import java.util.Random;

public class MyRandom {

    public static Random rnd = new Random(System.currentTimeMillis());
    public static int generateRandom(int min,int max){
        return rnd.nextInt(max - min + 1) + min;
    }
}
