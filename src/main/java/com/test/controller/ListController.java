package com.test.controller;

import com.test.domain.Transaction;
import com.test.service.transaction.TransactionService;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ListController {
    TransactionService transactionService;
    UserService userService;

    @Autowired
    public ListController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listTransactions(Model model){
        try{
            List<Transaction> transaction=transactionService.getAllTransaction();
            model.addAttribute("transactions",transaction);
        }
        catch (Exception e){
        }
        return "list";
    }
}
