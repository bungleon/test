package com.test.service.transaction;

import com.test.domain.Transaction;
import com.test.model.request.TransactionRequest;

import java.util.List;

public interface TransactionService {

    public Transaction saveTransaction(TransactionRequest transactionRequest,String userId);
    public List<Transaction> getAllTransaction();
}
