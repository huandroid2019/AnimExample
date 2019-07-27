package example.com.animexample;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class ValueAnimActivity extends AppCompatActivity {
    int inx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);
        //метод с созданимем и запуском анимации из кода
        valueAnimJava();
        //метод с созданием анимации из xml
        valueAnimXML();
    }

    /**
     * создание и запуск анимации из XML
     */
    void valueAnimXML(){
        final Button btn = findViewById(R.id.btn_fly_away);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimJava();
            }
        });
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater
                .loadAnimator(this,R.animator.value_animator_ex);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                btn.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator.start();
    }
    /**
     * создаем и запускаем анимацию из кода
     */
    void valueAnimJava(){
        final TextView textView = findViewById(R.id.tv_value_anim);
        //создаем аниматор
        ValueAnimator valueAnimator = ValueAnimator.ofArgb(0,0xff000000);
        //интерполятор необязателен
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        //устанавливаем длительность в мс (по умолчанию 300)
        valueAnimator.setDuration(8000);
//        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
 //       valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        inx = 0;
        //добавляем слушатель, в котором определим, что должно меняться у view
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //просто меняем цвет
                int color = (int) animation.getAnimatedValue();

                textView.setTextColor(color);
                inx++;
                Log.d("value anim","value:"+animation.getAnimatedValue()+"inx="+inx);
            }

        });
        //необязательный здесь станлдартный слушатель анимации
        //в данном случае отслеживаем событие конца анимации и добалвяем надпись в textView
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                findViewById(R.id.btn_fly_away).setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                textView.setText(textView.getText()+"\nend");
                textView.setTextColor(Color.RED);
                findViewById(R.id.btn_fly_away).setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();

    }
}
