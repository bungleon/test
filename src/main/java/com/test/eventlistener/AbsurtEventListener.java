package com.test.eventlistener;

import com.test.events.AbsurtEvent;
import com.test.events.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
class AbsurtEventListener implements ApplicationListener<AbsurtEvent> {
    public void onApplicationEvent(AbsurtEvent event) {
        System.out.println(event.toString());
    }
}
