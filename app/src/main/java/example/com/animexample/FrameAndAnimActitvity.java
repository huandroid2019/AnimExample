package example.com.animexample;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class FrameAndAnimActitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_and_anim_actitvity);
        animrotateWxample();
        //запуск анимации по клику в разметке
        findViewById(R.id.cl_frame_and_anim_lay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable drawable = createFrameAnimAtRuntime();
                v.setBackground(drawable);
                drawable.start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        animframeExample();
    }

    /**
     * покадровая анимация програмно
     */
    AnimationDrawable createFrameAnimAtRuntime(){
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_1),500);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_2),500);
        animationDrawable.addFrame(getResources().getDrawable(R.mipmap.num_3),500);
        animationDrawable.setOneShot(true);
        return animationDrawable;
    }
    /**
     * пример запуска покадровой анимации из xml
     */
    void animframeExample(){
        AnimationDrawable animationDrawable = (AnimationDrawable) findViewById(R.id.iv_frame_anim).getBackground();
        animationDrawable.start();
    }

    /**
     * анимация поворота из xml
     */
    void animrotateWxample(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
        findViewById(R.id.btn_anim_rotation).startAnimation(animation);

    }

}
