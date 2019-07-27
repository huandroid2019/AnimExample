package example.com.animexample;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button[] btns=new Button[4];
    Animation[] anim=new Animation[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        prepare_btns_anim();


    }
    void prepare_btns_anim(){
        btns[0] = (Button)findViewById(R.id.btn_vlue_anim);
        btns[1]=(Button)findViewById(R.id.btn_obect_anim);
        btns[2]=(Button)findViewById(R.id.btn_anim_examples);
        btns[3]=(Button)findViewById(R.id.btn_vector_anim);
        for(int i=0;i<btns.length;i++){
            anim[i]= AnimationUtils.loadAnimation(this, R.anim.scale1);
            anim[i].setStartOffset(400*i);
        }
    }
    public void onClick(View v){

        switch (v.getId()){
            case R.id.btn_vlue_anim:
                startActivity(new Intent(this,ValueAnimActivity.class));
                overridePendingTransition(R.anim.activity_bounce_in,R.anim.rotate_and_go_right);
                break;
            case R.id.btn_obect_anim:
                startActivity(new Intent(this,ObjectAnimatorActivity.class));
                overridePendingTransition(R.anim.rotate_and_go_from_left,R.anim.rotate_and_go_right);
                break;
            case R.id.btn_anim_examples:
                startActivity(new Intent(this,FrameAndAnimActitvity.class));
                overridePendingTransition(R.anim.scale_activity,R.anim.anim_right_down);
                break;
            case R.id.btn_vector_anim:
                startActivity(new Intent(this,VectorAnimActivity.class));
                overridePendingTransition(R.anim.anim_leftt_up,R.anim.anim_right_down);
                break;
        }



        //TransitionManager.beginDelayedTransition((ViewGroup) v.getRootView(),fade);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for(int i=0;i<btns.length;i++){
            btns[i].startAnimation(anim[i]);
        }
    }
}
