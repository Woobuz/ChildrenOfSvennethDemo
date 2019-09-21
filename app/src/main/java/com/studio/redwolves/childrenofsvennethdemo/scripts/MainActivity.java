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
import com.studio.redwolves.childrenofsvennethdemo.models.FoodStorage;
import com.studio.redwolves.childrenofsvennethdemo.models.WoodStorage;
import com.studio.redwolves.childrenofsvennethdemo.scripts.MapActivity;
import com.studio.redwolves.childrenofsvennethdemo.scripts.WoodsActivity;

public class MainActivity extends Activity {
    private Button goToForestButton;
    private Button goToWorldMapButton;
    private WoodStorage currentWood;
    private FoodStorage currentFood;
    private ImageView buildingSpace;
    private ImageView magicHouse;
    private ImageView woodIcon;
    private ImageView foodIcon, requiredWoodx;
    private TextView requiredWood;
    private TextView foodAvailable;
    private TextView woodAvailable;
    private ImageView marketplace;
    private Button showResourcesButton;
    private static boolean placeVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        currentWood = new WoodStorage();
        buildingSpace = findViewById(R.id.buildingSpace);
        magicHouse = findViewById(R.id.magichouse);
        requiredWood = findViewById(R.id.requiredWood);
        requiredWoodx = findViewById(R.id.requiredWoodx);
        marketplace = findViewById(R.id.marketplace);


        showResourcesButton = findViewById(R.id.showResourcesButton);
        woodIcon = findViewById(R.id.woodiconx);
        foodIcon = findViewById(R.id.foodIcon);
        foodAvailable = findViewById(R.id.globalFood);
        woodAvailable = findViewById(R.id.globalWood);

        woodIcon.setVisibility(View.INVISIBLE);
        foodIcon.setVisibility(View.INVISIBLE);
        foodAvailable.setVisibility(View.INVISIBLE);
        woodAvailable.setVisibility(View.INVISIBLE);

        final String existingWood = ""+currentWood.getWood();
        final TextView woodStorageOnLoad = findViewById(R.id.globalWood);
        woodStorageOnLoad.setText(existingWood);

        setVisibilityOfBuildingPlace();

        buildingSpace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (currentWood.useWood(120) == true){
                    placeVisible = false;
                    final String newWood = ""+currentWood.getWood();
                    woodStorageOnLoad.setText(newWood);
                }
                setVisibilityOfBuildingPlace();
            }
        });

        showResourcesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (woodIcon.getVisibility() == View.INVISIBLE){
                    woodIcon.setVisibility(View.VISIBLE);
                    foodIcon.setVisibility(View.VISIBLE);
                    foodAvailable.setText(""+currentFood.getFood());
                    foodAvailable.setVisibility(View.VISIBLE);
                    woodAvailable.setVisibility(View.VISIBLE);
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    woodIcon.setVisibility(View.INVISIBLE);
                                    foodIcon.setVisibility(View.INVISIBLE);
                                    foodAvailable.setVisibility(View.INVISIBLE);
                                    woodAvailable.setVisibility(View.INVISIBLE);
                                }
                            }, 2000);
                }
            }
        });

        goToForest();
        goToWorldMap();
        goToMagicHouse();
        goToMarketplace();
    }

    @Override
    public void onBackPressed(){

    }

    public void setVisibilityOfBuildingPlace(){
        if (placeVisible == true){
            requiredWood.setVisibility(View.VISIBLE);
            requiredWoodx.setVisibility(View.VISIBLE);
            buildingSpace.setVisibility(View.VISIBLE);
            magicHouse.setVisibility(View.INVISIBLE);
        } else {
            requiredWood.setVisibility(View.INVISIBLE);
            requiredWoodx.setVisibility(View.INVISIBLE);
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

    public void goToMarketplace(){
        marketplace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                walkToMarketplace();
            }
        });
    }

    public void walkToMarketplace(){
        Intent intent = new Intent(this, MarketplaceActivity.class);
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
