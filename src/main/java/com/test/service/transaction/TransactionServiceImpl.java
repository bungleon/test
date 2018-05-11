package com.test.service.transaction;

import com.test.domain.Transaction;
import com.test.domain.User;
import com.test.model.request.TransactionRequest;
import com.test.repository.TransactionRepository;
import com.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;
    UserRepository userRepository;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Transaction saveTransaction(TransactionRequest transactionRequest,String userId){
        Transaction transaction=new Transaction();
        transaction.setName(transactionRequest.getName());
        transaction.setMessage(transactionRequest.getMessage());

        User user=userRepository.findById(UUID.fromString(userId));
        transaction.setUser(user);
        return transactionRepository.save(transaction);
    }
    @Override
    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }
}
