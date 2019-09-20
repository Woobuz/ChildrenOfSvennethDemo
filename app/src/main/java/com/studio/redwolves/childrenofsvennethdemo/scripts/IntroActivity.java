package com.studio.redwolves.childrenofsvennethdemo.scripts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.studio.redwolves.childrenofsvennethdemo.R;

public class IntroActivity extends Activity {
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

    }

    @Override
    public void onBackPressed(){

    }

    public void next(){
        next = findViewById(R.id.nextButton);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("tag","AAAAA");
            }
        });
    }
}
