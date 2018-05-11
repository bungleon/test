package com.test.service.bank;

import com.test.domain.Bank;
import com.test.model.request.BankRequest;
import com.test.model.response.BankResponse;
import com.test.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    public bankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BankResponse saveBank(BankRequest bankRequest) {
        Bank bank=bankRepository.findBySwiftCode(bankRequest.getSwiftCode());
        if(bank==null){
            bank=new Bank();
        }
        bank.setSwiftCode(bankRequest.getSwiftCode());
        bank.setName(bankRequest.getBankName());
        bankRepository.save(bank);
        return new BankResponse();
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }
}
