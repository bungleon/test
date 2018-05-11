package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateTransactions  {

    /*@Autowired
    TransactionService transactionService;*/

    @PostConstruct
    public void init() {
        createRandomTransaction();
        createRandomTransaction();
        createRandomTransaction();
        createRandomTransaction();
        createRandomTransaction();
    }
    public void createRandomTransaction() {
        /*TransactionModel transactionModel;
        TransactionModel.TransactionModelBuilder model;
        model = TransactionModel.builder().status(Status.WAITING)
                .amount(new BigDecimal(Math.random()))
                .currency("TRY")
                .sourceReferenceNo(UUID.randomUUID())
                .bankSwiftCode("ABCDE");
        transactionModel = model.build();
        transactionService.create(transactionModel);*/
    }
    @Test
    public void test(){}
}
