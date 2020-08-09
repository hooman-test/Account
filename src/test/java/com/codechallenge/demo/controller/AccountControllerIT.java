package com.codechallenge.demo.controller;

import com.codechallenge.demo.entity.Account;
import com.codechallenge.demo.fixture.DataFixture;
import com.codechallenge.demo.registry.AccountRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerIT {

    @MockBean
    private AccountRepo accountRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAccount() throws Exception {
        List<Account> accountList = DataFixture.getAccountList();
        when(accountRepo.findAll()).thenReturn(accountList);
        mockMvc.perform(MockMvcRequestBuilders.get("/account"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testGetAccountTransactions() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/transaction"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testGetAccountTransactionsWithId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/transaction?accountId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
