package com.studio.redwolves.childrenofsvennethdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.studio.redwolves.childrenofsvennethdemo.models.WoodStorage;
import com.studio.redwolves.childrenofsvennethdemo.scripts.WoodsActivity;

public class MainActivity extends Activity {
    private Button goToForestButton;
    private WoodStorage currentWood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentWood = new WoodStorage();

        String existingWood = "Wood: "+currentWood.getWood();
        final TextView woodStorageOnLoad = findViewById(R.id.globalWood);
        woodStorageOnLoad.setText(existingWood);

        goToForest();
    }

    @Override
    public void onBackPressed(){

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
}
