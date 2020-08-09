package com.codechallenge.demo;

import com.codechallenge.demo.controller.AccountController;
import com.codechallenge.demo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {
    private final AccountController accountController;
    private final AccountService accountService;

    @Autowired
    public DemoApplicationTests(AccountController accountController, AccountService accountService) {
        this.accountController = accountController;
        this.accountService = accountService;
    }

    @Test
    void contextLoads() {
        assertNotNull(accountController);
        assertNotNull(accountService);
    }

}
