package com.hkc.lifecycletest2;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyChronometer extends Chronometer implements LifecycleObserver {
    private long elapsedtime;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startMeter(){
        setBase(SystemClock.elapsedRealtime() - elapsedtime);
        start();

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void stopMeter(){
        elapsedtime = SystemClock.elapsedRealtime() - getBase();
        stop();
    }
}
