package com.test.controller;

import com.test.model.request.TransactionRequest;
import com.test.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class TransactionController {

    TransactionService  transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model,HttpSession session){
        String userId=session.getAttribute("userId").toString();
        if(userId.equals("")){
            model.addAttribute("userName2","Yürü git");
            return "redirect:/login";
        }
        else {
            return "test";
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String saveTransaction(Model model, TransactionRequest transactionRequest, HttpSession session){
        String userId=session.getAttribute("userId").toString();
        System.out.println(userId);
        System.out.println(transactionRequest.toString());
        try{
            transactionService.saveTransaction(transactionRequest,userId);
            model.addAttribute("retValue","Adding Successful");
        }catch (Exception e){
            model.addAttribute("retValue","Adding Failed "+e.getMessage());
        }
        return "test";
    }

    @RequestMapping(value = "/listTransaction", method = RequestMethod.POST)
    public String listTransaction(Model model){
        return "redirect:/list";
    }
}
