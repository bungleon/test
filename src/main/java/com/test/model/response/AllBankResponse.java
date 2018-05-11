package com.test.model.response;

import com.test.domain.Bank;

import java.util.List;

public class AllBankResponse {
    List<Bank> bankList;

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }
}
