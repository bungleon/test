package com.test.controller;

import com.test.model.request.BankRequest;
import com.test.model.response.AllBankResponse;
import com.test.model.response.BankResponse;
import com.test.service.bank.BankService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(value = "/bank/save", method = RequestMethod.POST)
    public BankResponse bankSave(@RequestBody BankRequest bankRequest){
        return bankService.saveBank(bankRequest);
    }

    @RequestMapping(value = "/bank/get-all", method = RequestMethod.POST)
    public AllBankResponse getAllBanks(){
        AllBankResponse allBankResponse=new AllBankResponse();
        allBankResponse.setBankList(bankService.getAllBanks());
        return allBankResponse;
    }
}
