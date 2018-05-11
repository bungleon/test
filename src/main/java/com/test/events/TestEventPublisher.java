package com.test.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class TestEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    private String data;

    public void setApplicationEventPublisher (ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    public void publish() {
        TestEvent testEvent= new TestEvent("publisher");
        publisher.publishEvent(testEvent);
        AbsurtEvent absurtEvent = new AbsurtEvent("","","");
        publisher.publishEvent(absurtEvent);
    }
}
