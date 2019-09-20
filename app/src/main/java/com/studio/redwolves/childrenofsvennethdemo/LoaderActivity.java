package com.studio.redwolves.childrenofsvennethdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.studio.redwolves.childrenofsvennethdemo.R;
import com.studio.redwolves.childrenofsvennethdemo.scripts.MapActivity;
import com.studio.redwolves.childrenofsvennethdemo.scripts.WoodsActivity;

public class LoaderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        loadMap();
                    }}, 3000);
    }

    @Override
    public void onBackPressed(){

    }

    public void loadMap(){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
