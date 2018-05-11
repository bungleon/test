package com.test.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class DomainEvent {
    private final ApplicationEventPublisher applicationEventPublisher;

    public DomainEvent(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void fire(Event event) {
        applicationEventPublisher.publishEvent(event);
    }
}
