package com.studio.redwolves.childrenofsvennethdemo.scripts;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.redwolves.childrenofsvennethdemo.R;
import com.studio.redwolves.childrenofsvennethdemo.models.FoodStorage;
import com.studio.redwolves.childrenofsvennethdemo.models.WoodStorage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class WoodsActivity extends Activity {
    private Button goBack;
    private FoodStorage currentFood;
    private WoodStorage currentWood;
    private ImageView tree;
    private ImageView deer, foodPlus;
    private TextView foodPlusInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woods);

        currentWood = new WoodStorage();

        tree = findViewById(R.id.tree);
        deer = findViewById(R.id.deer);
        foodPlus = findViewById(R.id.foodPlus);
        foodPlusInfo = findViewById(R.id.addFoodInfo);

        foodPlusInfo.setVisibility(View.INVISIBLE);
        foodPlus.setVisibility(View.INVISIBLE);

        String existingWood = ""+currentWood.getWood();
        final TextView woodStorageOnLoad = findViewById(R.id.woodStorage);
        woodStorageOnLoad.setText(existingWood);

        addWood();
        goBack();

        deer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                deer.setVisibility(View.INVISIBLE);
                Random r = new Random();
                final int newFood = (r.nextInt(15 - 5) + 5);
                currentFood.addFood(newFood);
                final String newWoodAdd = "+ "+newFood;
                foodPlusInfo.setText(newWoodAdd);
                foodPlus.setVisibility(View.VISIBLE);
                foodPlusInfo.setVisibility(View.VISIBLE);

                final ObjectAnimator animation = ObjectAnimator.ofFloat(foodPlusInfo, "translationY", -100f);
                animation.setDuration(2000);
                animation.start();
                final ObjectAnimator animation2 = ObjectAnimator.ofFloat(foodPlus, "translationY", -100f);
                animation2.setDuration(2000);
                animation2.start();

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                animation.setFloatValues(100f);
                                animation2.setFloatValues(100f);
                                animation.setDuration(1);
                                animation2.setDuration(1);
                                animation.start();
                                animation2.start();

                                foodPlus.setVisibility(View.INVISIBLE);
                                foodPlusInfo.setVisibility(View.INVISIBLE);
                            }
                        }, 2000);
            }
        });

        Timer xtimer = new Timer();

        xtimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Random r = new Random();
                        int random = r.nextInt(10);

                        if (random == 5) {
                            deer.setVisibility(View.VISIBLE);
                        } else {
                            deer.setVisibility(View.INVISIBLE);
                        }
                    }});
                }
            },0,2000);
        }

    @Override
    public void onBackPressed(){

    }

    public void addWood(){

        final TextView woodStorage = findViewById(R.id.woodStorage);
        Button clickableArea = findViewById(R.id.clickableResourceArea);

        clickableArea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                currentWood.addWood();
                String newValue = ""+currentWood.getWood();
                woodStorage.setText(newValue);

                tree.setScaleX(0.9f);
                tree.setScaleY(0.9f);

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                tree.setScaleX(1f);
                                tree.setScaleY(1f);
                            }}, 50);
            }
        });
    }

    public void goBack(){
        goBack = findViewById(R.id.goBackToVillage);
        goBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goBackToVillage();
            }
        });
    }

    public void goBackToVillage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
