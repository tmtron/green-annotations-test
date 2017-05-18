package com.tmtron.greenannotationstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tmtron.greenannotations.EventBusGreenRobot;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.tvMain) TextView tvMain;

    @EventBusGreenRobot
    EventBus eventBus;

    @Override
    public void onStart() {
        // just a test for issue #13: https://github.com/tmtron/green-annotations/issues/13
        Toast.makeText(getApplicationContext(), "Before Start", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Click
    void btnTest() {
        eventBus.post(new MessageEvent("+."));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(getApplicationContext(), event.getMessage(), Toast.LENGTH_SHORT).show();
        tvMain.setText(tvMain.getText()+"-.");
    }

}
