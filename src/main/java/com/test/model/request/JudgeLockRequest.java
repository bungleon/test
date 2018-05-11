package com.test.model.request;

import java.util.UUID;

public class JudgeLockRequest {
    Integer id;
    UUID referenceNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(UUID referenceNo) {
        this.referenceNo = referenceNo;
    }

    @Override
    public String toString() {
        return "JudgeLockRequest{" +
                "id=" + id +
                ", referenceNo=" + referenceNo +
                '}';
    }
}
