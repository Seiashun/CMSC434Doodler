package com.code.cmsc434.cmsc434doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thomasyang on 11/2/16.
 */

public class DoodleView extends View {

    List<Stroke> _strokes = new ArrayList<Stroke>();
    List<Stroke> _undo = new ArrayList<Stroke>();
    private Paint _paintDoodle = new Paint();
    private Path _path = new Path();

    private int color;
    private float width;

    public DoodleView(Context context) {
        super(context);
        init(null, 0);
        color = Color.BLACK;
        width = 4.0f;
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
        color = Color.BLACK;
        width = 4.0f;
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
        color = Color.BLACK;
        width = 4.0f;
    }

    public void setAlpha(int percent) {
        int color = _paintDoodle.getColor();
        int alpha = (int) (255 * (percent / 100.0));
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        setBrushColor(alpha, red, green, blue);
    }

    public void setRed(int percent) {
        int color = _paintDoodle.getColor();
        int alpha = Color.alpha(color);
        int red = (int) (255 * (percent / 100.0));
        int green = Color.green(color);
        int blue = Color.blue(color);

        setBrushColor(alpha, red, green, blue);
    }

    public void setGreen(int percent) {
        int color = _paintDoodle.getColor();
        int alpha = Color.alpha(color);
        int red = Color.red(color);
        int green = (int) (255 * (percent / 100.0));
        int blue = Color.blue(color);

        setBrushColor(alpha, red, green, blue);

    }

    public void setBlue(int percent) {
        int color = _paintDoodle.getColor();
        int alpha = Color.alpha(color);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = (int) (255 * (percent / 100.0));

        setBrushColor(alpha, red, green, blue);

    }

    public void setSize(int percent) {
        width = 4.0f + (36.0f * (float)(percent / 100.0));
        _paintDoodle.setStrokeWidth(width);
    }

    public void undo() {
        if (_strokes.size() > 0) {
            _undo.add(_strokes.remove(_strokes.size() - 1));
            invalidate();
        }
    }

    public void redo() {
        if (_undo.size() > 0) {
            _strokes.add(_undo.remove(_undo.size() - 1));
            invalidate();
        }
    }

    public int canUndo() {
        return _strokes.size();
    }

    public int canRedo() {
        return _undo.size();
    }

    private void setBrushColor(int a, int r, int g, int b) {
        _paintDoodle.setARGB(a, r, g, b);
        color = _paintDoodle.getColor();
        invalidate();
    }

    public void clearScreen() {
        _strokes.clear();
        _undo.clear();
        invalidate();
    }

    private void init(AttributeSet attrs, int defStyle) {
        _paintDoodle.setColor(Color.BLACK);
        _paintDoodle.setAntiAlias(true);
        _paintDoodle.setStyle(Paint.Style.STROKE);
        _paintDoodle.setStrokeWidth(4.0f);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Stroke s : _strokes) {
            canvas.drawPath(s.path, s.doodle);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();

        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                _strokes.add(new Stroke(color, width));
                _strokes.get(_strokes.size() - 1).path.moveTo(touchX, touchY);
                //_path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                _strokes.get(_strokes.size() - 1).path.lineTo(touchX, touchY);
                //_path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                _undo.clear();
                break;
        }
        invalidate();
        return true;
    }

    private class Stroke {
        private Paint doodle;
        private Path path;

        public Stroke(int color, float width) {
            doodle = new Paint();
            path = new Path();

            doodle.setColor(color);
            doodle.setAntiAlias(true);
            doodle.setStyle(Paint.Style.STROKE);
            doodle.setStrokeWidth(width);
        }
    }
}