package com.test.model.response;

import java.math.BigDecimal;
import java.util.UUID;

public class JudgeLockResponse {
    private Integer id;
    private BigDecimal amount;
    private String bankAccount;
    private String swiftCode;
    private UUID sourceReferenceNo;
    private String message;

    public JudgeLockResponse(Integer id, BigDecimal amount, String bankAccount, String swiftCode, UUID sourceReferenceNo, String message) {
        this.id = id;
        this.amount = amount;
        this.bankAccount = bankAccount;
        this.swiftCode = swiftCode;
        this.sourceReferenceNo = sourceReferenceNo;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public UUID getSourceReferenceNo() {
        return sourceReferenceNo;
    }

    public void setSourceReferenceNo(UUID sourceReferenceNo) {
        this.sourceReferenceNo = sourceReferenceNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JudgeLockResponse{" +
                "id=" + id +
                ", amount=" + amount +
                ", bankAccount='" + bankAccount + '\'' +
                ", swiftCode='" + swiftCode + '\'' +
                ", sourceReferenceNo=" + sourceReferenceNo +
                ", message='" + message + '\'' +
                '}';
    }
}
