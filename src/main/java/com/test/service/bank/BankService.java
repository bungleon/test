package com.test.service.bank;

import com.test.domain.Bank;
import com.test.model.request.BankRequest;
import com.test.model.response.BankResponse;

import java.util.List;

public interface BankService {
    BankResponse saveBank(BankRequest bankRequest);
    List<Bank> getAllBanks();
}
