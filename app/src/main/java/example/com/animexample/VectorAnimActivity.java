package example.com.animexample;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VectorAnimActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_anim);
        Button btn_vector_hand_anim = findViewById(R.id.btn_vectr_hands);
        Drawable drawable = getDrawable(R.drawable.anim_vector);
        btn_vector_hand_anim.setBackground(drawable);
        btn_vector_hand_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animatable animatable = (Animatable) v.getBackground();
                animatable.start();
            }
        });
        findViewById(R.id.iv_vector_anim_ex).setBackgroundResource(R.drawable.off_on_anim);
        findViewById(R.id.iv_vector_anim_ex).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AnimatedVectorDrawable)v.getBackground()).start();
            }
        });
        findViewById(R.id.iv_ab_transform).setBackgroundResource(R.drawable.a_b_anim);
        findViewById(R.id.iv_ab_transform).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatedVectorDrawable avd = (AnimatedVectorDrawable)v.getBackground();
                avd.start();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_leftt_up,R.anim.anim_right_down);
    }
}
