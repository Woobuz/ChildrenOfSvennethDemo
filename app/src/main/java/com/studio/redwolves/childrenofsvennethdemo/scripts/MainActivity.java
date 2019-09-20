package com.studio.redwolves.childrenofsvennethdemo.scripts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.redwolves.childrenofsvennethdemo.R;
import com.studio.redwolves.childrenofsvennethdemo.models.WoodStorage;
import com.studio.redwolves.childrenofsvennethdemo.scripts.MapActivity;
import com.studio.redwolves.childrenofsvennethdemo.scripts.WoodsActivity;

public class MainActivity extends Activity {
    private Button goToForestButton;
    private Button goToWorldMapButton;
    private WoodStorage currentWood;
    private ImageView buildingSpace;
    private ImageView magicHouse;
    private static boolean placeVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currentWood = new WoodStorage();
        buildingSpace = findViewById(R.id.buildingSpace);
        magicHouse = findViewById(R.id.magichouse);

        setVisibilityOfBuildingPlace();

        buildingSpace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    placeVisible = false;
                    setVisibilityOfBuildingPlace();
            }
        });

        String existingWood = "Wood: "+currentWood.getWood();
//        final TextView woodStorageOnLoad = findViewById(R.id.globalWood);
//        woodStorageOnLoad.setText(existingWood);

        goToForest();
        goToWorldMap();
        goToMagicHouse();
    }

    @Override
    public void onBackPressed(){

    }

    public void setVisibilityOfBuildingPlace(){
        if (placeVisible == true){
            buildingSpace.setVisibility(View.VISIBLE);
            magicHouse.setVisibility(View.INVISIBLE);
        } else {
            buildingSpace.setVisibility(View.INVISIBLE);
            magicHouse.setVisibility(View.VISIBLE);
        }
    }

    public void goToForest(){
        goToForestButton = findViewById(R.id.button_woodcutter);
        goToForestButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                walkToForest();
            }
        });
    }

    public void walkToForest(){
        Intent intent = new Intent(this, WoodsActivity.class);
        startActivity(intent);
    }

    public void goToMagicHouse(){
        magicHouse = findViewById(R.id.magichouse);
        magicHouse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                walkToMagicHouse();
            }
        });
    }

    public void walkToMagicHouse(){
        Intent intent = new Intent(this, MagicHouseActivity.class);
        startActivity(intent);
    }

    public void goToWorldMap(){
        goToWorldMapButton = findViewById(R.id.button_world);
        goToWorldMapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showWorldMap();
            }
        });
    }

    public void showWorldMap(){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
