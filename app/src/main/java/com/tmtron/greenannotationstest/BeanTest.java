package com.tmtron.greenannotationstest;

import com.tmtron.greenannotations.EventBusGreenRobot;

import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.EventBus;

@EBean
class BeanTest {
    static final String EVENT_IDENTIFIER = "bean4EventTest-id";

    @SuppressWarnings("all")
    @EventBusGreenRobot
    protected EventBus eventBus;

    void fireEvent() {
        eventBus.post(new MessageEvent(EVENT_IDENTIFIER));
    }

}
