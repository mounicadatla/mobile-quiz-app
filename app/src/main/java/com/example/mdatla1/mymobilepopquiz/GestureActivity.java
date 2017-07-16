package com.example.mdatla1.mymobilepopquiz;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


import com.example.mdatla1.mymobilepopquiz.fragment.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GestureActivity extends BaseActivity implements  View.OnTouchListener{
//
   private GestureDetector  gestureDetector;
    private int location=0;
    private int sumX=0;
    private int sumY=0;

    @BindView(R.id.activity_gesture_tv)
    TextView tv;
    
public void trans(){
    ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "translationY", 0, 200, -200,0,100); //translationY
    animator.setDuration(2000);
    animator.start();
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
       ButterKnife.bind(this);
          gestureDetector = new GestureDetector(this, new simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
       return gestureDetector.onTouchEvent(event);
//        return false;
    }
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapUp");
            return false;
//            return super.onSingleTapUp(e);//
        }

        @Override
        public void onLongPress(MotionEvent e) {
            UtilLog.d("Gesture","onLongPress");

            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            UtilLog.d("Gesture","onScroll");

//            UtilLog.d("Gesture","distanceX"+distanceX);
//            UtilLog.d("Gesture","distanceY"+distanceY);
            sumX+=distanceX;
            sumY+=distanceY;

            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            UtilLog.d("Gesture","onFling");
if (sumX<0){
if(Math.abs(sumX)>200){
    shortToast("You scrolled from left to right");

}
}
            if (sumX>200){
                shortToast("You scrolled from right to left");
            }

            if (sumY<0){
                if(Math.abs(sumY)>200){
                    shortToast("You scrolled from Top to bottom");

                }
            }
            if (sumY>200){
                shortToast("You scrolled from bottom to top");
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            UtilLog.d("Gesture","onShowPress");

            super.onShowPress(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            UtilLog.d("Gesture","onDown");

            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTap");

            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTapEvent");

            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapConfirmed");

            return super.onSingleTapConfirmed(e);
        }

    }

}
