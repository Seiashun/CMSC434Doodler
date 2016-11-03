package com.code.cmsc434.cmsc434doodler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_clear = (Button) findViewById(R.id.id_button_clear);

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.clearScreen();
            }
        });
    }
}
