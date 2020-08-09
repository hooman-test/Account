package com.codechallenge.demo.fixture;

import com.codechallenge.demo.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
public class DataFixture {

    public static List<Account> getAccountList() {
        List<Account> accountList = new ArrayList<>();
        Account account;
        for (int i = 0; i < 10; i++) {
            account = new Account();
            account.setId((long) i);
            account.setAccountNumber("account-" + i);
            account.setBalance(new Amount(new BigDecimal(20 * i), Currency.getInstance("USD")));
            account.setBalanceDate(LocalDate.now());
            account.setType(AccountType.SAVING);
            accountList.add(account);
        }
        return accountList;
    }

    public static List<Transaction> getTransactionList() {
        List<Transaction> transactionList = new ArrayList<>();
        List<Account> accountList = getAccountList();

        Transaction transaction;
        for (int i = 0; i < 10; i++) {
            transaction = new Transaction();
            transaction.setId((long) i);
            transaction.setAccount(accountList.get(i));
            transaction.setAmount(new Amount(new BigDecimal(i + 10), Currency.getInstance("USD")));
            transaction.setAmountType(TransactionAmountType.CREDIT);
            transaction.setDate(LocalDate.now());
            transaction.setNarrative("Sample transaction");
            transactionList.add(transaction);
        }
        return transactionList;
    }
}
