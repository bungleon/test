package com.test.eventlistener;

import com.test.events.AbsurtEvent;
import com.test.events.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class CustomEventListener implements ApplicationListener<TestEvent> {
    public void onApplicationEvent(TestEvent event) {
        System.out.println(event.getSourceReferenceNo());
    }
}
