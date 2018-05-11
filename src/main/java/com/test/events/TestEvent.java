package com.test.events;

public class TestEvent extends Event {
    private final String sourceReferenceNo;

    public TestEvent(String source) {
        super(source);
        this.sourceReferenceNo = source;
    }

    public String getSourceReferenceNo() {
        return sourceReferenceNo;
    }
}
