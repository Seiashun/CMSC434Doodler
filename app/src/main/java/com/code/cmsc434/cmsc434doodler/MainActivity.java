package com.code.cmsc434.cmsc434doodler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_clear = (Button) findViewById(R.id.id_button_clear);
        ImageButton b_undo = (ImageButton) findViewById(R.id.id_undo_button);
        ImageButton b_redo = (ImageButton) findViewById(R.id.id_redo_button);

        final SeekBar seek_alpha = (SeekBar) findViewById(R.id.id_seek_alpha);
        final SeekBar seek_red = (SeekBar) findViewById(R.id.id_seek_red);
        final SeekBar seek_green = (SeekBar) findViewById(R.id.id_seek_green);
        final SeekBar seek_blue = (SeekBar) findViewById(R.id.id_seek_blue);
        final SeekBar seek_size = (SeekBar) findViewById(R.id.id_seek_size);

        b_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.clearScreen();

                seek_alpha.setProgress(100);
                seek_red.setProgress(0);
                seek_green.setProgress(0);
                seek_blue.setProgress(0);
                seek_size.setProgress(0);
            }
        });

        b_undo.setOnClickListener(new ImageButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.undo();
            }
        });

        b_redo.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.redo();
            }
        });

        seek_alpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.setAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seek_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.setRed(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seek_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.setBlue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seek_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.setGreen(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seek_size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView dv = (DoodleView) findViewById(R.id.id_doodleview);
                dv.setSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
