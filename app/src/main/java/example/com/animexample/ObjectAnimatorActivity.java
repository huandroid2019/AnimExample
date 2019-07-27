package example.com.animexample;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.VectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class ObjectAnimatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn_first);
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(btn,"translationX",500f,0);
        animatorX.setDuration(5000);
        animatorX.setRepeatMode(ValueAnimator.REVERSE);
        animatorX.setTarget(findViewById(R.id.btn_first));
        animatorX.start();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animforImage();
            }
        });
        findViewById(R.id.iv_car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animWithCustomInterpolator();
                v.setEnabled(false);
            }
        });
    }

    /**
     * анимация вдоль пути
     */
    void alongPathAnimExample(){
        Path path = new Path();

        ImageView iv_face = findViewById(R.id.iv_face);
        path.addCircle(0,0,100f,Path.Direction.CW);
        path.close();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                iv_face,View.TRANSLATION_X,View.TRANSLATION_Y,path);
        animator.setDuration(6000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }

    /**
     * анимация с собственным интерполятором
     */
    void animWithCustomInterpolator(){

        float h = findViewById(R.id.cl_object_anim).getHeight();
        final ImageView iv_car = findViewById(R.id.iv_car);
        ObjectAnimator objectAnimator = ObjectAnimator
                .ofFloat(iv_car,"translationY",0f,h/2)
                .setDuration(6000);
        objectAnimator.setInterpolator(new MyInterpolator());
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                iv_car.setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        objectAnimator.start();

    }

    /**
     * анимация свойств из xml
     */
    void animforImage(){
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.object_animator_example);
        set.setTarget(findViewById(R.id.iv_smile));
        set.start();
    }
    @Override
    protected void onResume() {
        ImageView v;

        super.onResume();
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.anim_fly_from_left);
        set.setTarget(findViewById(R.id.tv_text));
        set.start();
        alongPathAnimExample();
    }
}