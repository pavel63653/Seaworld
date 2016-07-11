package com.sibext.pavel.seaworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.sibext.pavel.seaworld.world.World;


public class MainActivity extends AppCompatActivity {

    private World world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTable();

    }
    private void createTable(){
        world = new World(Settings.MAXHEIGHT,Settings.MAXWIDTH);
        MyController controller = new MyController();
        world.setController(controller);
    }
    public void onClickRestart(View v){
        Log.d("MainActivity","restart");
        world.initialize();


    }
    public void onClickRun(View v){
        Log.d("MainActivity","run");
        world.run();
    }
    private class MyController implements Controller{

        public MyController(){
            LinearLayout mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);

            for (int i = 0; i < world.getHeight(); i++) {

                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                LinearLayout.LayoutParams lpt = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT,1.0f);
                linearLayout.setLayoutParams(lpt);
                linearLayout.setGravity(Gravity.CENTER);

                for (int j = 0; j < world.getWidth(); j++) {

                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setAdjustViewBounds(true);
                    if(world.getCell(i,j)==World.TUX)
                     imageView.setImageResource(R.drawable.tux);
                    else if(world.getCell(i,j)==World.ORCA)
                            imageView.setImageResource(R.drawable.orca);
                        else
                            imageView.setImageResource(android.R.color.transparent);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,1.0f);
                    lp.gravity = Gravity.CENTER;
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setLayoutParams(lp);
                    linearLayout.addView(imageView);


                }

                mainLinearLayout.addView(linearLayout);


            }
        }


        @Override
        public void show() {
            LinearLayout mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
            mainLinearLayout.removeAllViews();
            for (int i = 0; i < world.getHeight(); i++) {

                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                LinearLayout.LayoutParams lpt = new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT,1.0f);
                linearLayout.setLayoutParams(lpt);
                linearLayout.setGravity(Gravity.CENTER);

                for (int j = 0; j < world.getWidth(); j++) {

                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setAdjustViewBounds(true);
                    if(world.getCell(i,j)==World.TUX)
                        imageView.setImageResource(R.drawable.tux);
                    else if(world.getCell(i,j)==World.ORCA)
                        imageView.setImageResource(R.drawable.orca);
                    else
                        imageView.setImageResource(android.R.color.transparent);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT,1.0f);
                    lp.gravity = Gravity.CENTER;
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setLayoutParams(lp);
                    linearLayout.addView(imageView);


                }

                mainLinearLayout.addView(linearLayout);


            }
        }
    }
}
