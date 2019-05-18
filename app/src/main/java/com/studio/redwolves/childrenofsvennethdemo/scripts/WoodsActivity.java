package com.studio.redwolves.childrenofsvennethdemo.scripts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.studio.redwolves.childrenofsvennethdemo.MainActivity;
import com.studio.redwolves.childrenofsvennethdemo.R;
import com.studio.redwolves.childrenofsvennethdemo.models.WoodStorage;

public class WoodsActivity extends Activity {
    private Button goBack;
    private WoodStorage currentWood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woods);

        currentWood = new WoodStorage();

        String existingWood = "Wood: "+currentWood.getWood();
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
                String newValue = "Wood: "+currentWood.getWood();
                woodStorage.setText(newValue);
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
