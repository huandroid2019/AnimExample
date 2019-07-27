package example.com.animexample;

import android.view.animation.Interpolator;

public class MyInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float x) {
        return (float) Math.sin(x*Math.PI);
    }
}
