package com.studio.redwolves.childrenofsvennethdemo.scripts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.studio.redwolves.childrenofsvennethdemo.R;

public class MarketplaceActivity extends Activity {

    private Button goBackMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        goBack();
    }

    @Override
    public void onBackPressed(){

    }

    public void goBack(){
        goBackMP = findViewById(R.id.goBackMP);
        goBackMP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToTheVillage();
            }
        });
    }

    public void goToTheVillage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
