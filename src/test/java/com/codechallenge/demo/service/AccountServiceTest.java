package com.codechallenge.demo.service;

import com.codechallenge.demo.entity.Account;
import com.codechallenge.demo.entity.Transaction;
import com.codechallenge.demo.exception.AccountFetchException;
import com.codechallenge.demo.exception.AccountTransactionFetchException;
import com.codechallenge.demo.fixture.DataFixture;
import com.codechallenge.demo.registry.AccountRepo;
import com.codechallenge.demo.registry.TransactionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepo accountRepo;

    @Mock
    private TransactionRepo transactionRepo;

    @InjectMocks
    private AccountService accountService;

    private List<Account> accountList;
    private List<Transaction> transactionList;

    @BeforeEach
    void setUp() {
        accountList = DataFixture.getAccountList();
        transactionList = DataFixture.getTransactionList();
    }

    @Test
    void getAccount() {
        when(accountRepo.findAll()).thenReturn(accountList);
        assertEquals(10, accountService.getAccount().size());
    }

    @Test
    void getAccountTransaction() {
        when(transactionRepo.findAll()).thenReturn(transactionList);
        assertEquals(10, accountService.getAccountTransaction(null).size());
    }

    @Test
    void getAccountTransactionWithAccount() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transactionList.get(0));
        when(transactionRepo.findAllByAccount(any())).thenReturn(transactions);
        assertEquals(1, accountService.getAccountTransaction(1L).size());
    }

    @Test
    void getAccountWithNoRecords() {
        assertEquals(0, accountService.getAccount().size());
    }

    @Test
    void getAccountTransactionWithNoRecords() {
        assertEquals(0, accountService.getAccountTransaction(null).size());
    }

    @Test
    void getAccountTransactionWithAccountIdWithNoRecords() {
        assertEquals(0, accountService.getAccountTransaction(1L).size());
    }

    @Test
    void getAccountWithException() {
        when(accountRepo.findAll()).thenThrow(new AccountFetchException());
        assertThrows(AccountFetchException.class, () -> accountService.getAccount());
    }

    @Test
    void getAccountTransactionWithException() {
        when(transactionRepo.findAll()).thenThrow(new AccountTransactionFetchException());
        assertThrows(AccountTransactionFetchException.class, () -> accountService.getAccountTransaction(null));
    }

}
