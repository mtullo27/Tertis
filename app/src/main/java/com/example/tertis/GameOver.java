package com.example.tertis;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;

public class GameOverScreen extends AppCompatActivity implements View.OnTouchListener{

    private GameOverView gv ;
    private RelativeLayout layout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        layout = (RelativeLayout) findViewById(R.id.layout);
        gv = new GameOverView(this);
        layout.setOnTouchListener(this);
        layout.addView(gv);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if(action==MotionEvent.ACTION_DOWN) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }
        return false;
    }

    class GameOverView extends View {

        public GameOverView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            p.setTextSize(200);
            canvas.drawText("Game Over",50,400,p);
            p.setTextSize(75);
            canvas.drawText("Touch!!!",450,800,p);

        }
    }
}