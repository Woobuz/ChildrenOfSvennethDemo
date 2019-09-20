package com.studio.redwolves.childrenofsvennethdemo.scripts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.studio.redwolves.childrenofsvennethdemo.R;
import com.studio.redwolves.childrenofsvennethdemo.models.WoodStorage;

public class WoodsActivity extends Activity {
    private Button goBack;
    private WoodStorage currentWood;
    private ImageView tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woods);

        currentWood = new WoodStorage();

        tree = findViewById(R.id.tree);

        String existingWood = ""+currentWood.getWood();
        final TextView woodStorageOnLoad = findViewById(R.id.woodStorage);
        woodStorageOnLoad.setText(existingWood);

        addWood();
        goBack();
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
