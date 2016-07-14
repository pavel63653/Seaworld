package com.sibext.pavel.seaworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.sibext.pavel.seaworld.world.Orca;
import com.sibext.pavel.seaworld.world.World;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private World world;
    private List<List<ImageView>> linearLayoutList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTable();

    }
    private void createTable(){
        world = new World(Settings.MAXHEIGHT,Settings.MAXWIDTH);
        LinearLayout mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
        for (int i = 0; i < world.getHeight(); i++) {

            LinearLayout linearLayout = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams lpt = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT,1.0f);
            linearLayout.setLayoutParams(lpt);
            linearLayout.setGravity(Gravity.CENTER);
            List<ImageView> imageViewList = new ArrayList<>();
            linearLayoutList.add(imageViewList);
            for (int j = 0; j < world.getWidth(); j++) {

                ImageView imageView = new ImageView(MainActivity.this);
                imageViewList.add(imageView);
                imageView.setAdjustViewBounds(true);
                imageView.setImageResource(android.R.color.transparent);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,1.0f);
                lp.gravity = Gravity.CENTER;
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(lp);
                linearLayout.addView(imageView);

            }

            mainLinearLayout.addView(linearLayout);


        }
        show();
    }
    public void onClickRestart(View v){
        Log.d("MainActivity","restart");
        world.initialize();
        show();

    }
    public void onClickRun(View v){
        Log.d("MainActivity","run");
        world.run();
        show();
    }
    private void show(){
        for (int i = 0; i < world.getHeight(); i++) {
            for (int j = 0; j < world.getWidth(); j++) {
                ImageView imageView = linearLayoutList.get(i).get(j);
                int imageResource = android.R.color.transparent;
                if(world.getAnimal(j,i) != null){
                    imageResource = world.getAnimal(j,i).getImage();
                }
                imageView.setImageResource(imageResource);
            }
        }
    }

}
