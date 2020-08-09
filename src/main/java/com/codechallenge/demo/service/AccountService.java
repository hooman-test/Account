package com.codechallenge.demo.service;

import com.codechallenge.demo.dto.AccountDTO;
import com.codechallenge.demo.dto.TransactionDTO;
import com.codechallenge.demo.entity.Account;
import com.codechallenge.demo.entity.Transaction;
import com.codechallenge.demo.exception.AccountFetchException;
import com.codechallenge.demo.exception.AccountTransactionFetchException;
import com.codechallenge.demo.factory.AccountConverter;
import com.codechallenge.demo.factory.TransactionConverter;
import com.codechallenge.demo.registry.AccountRepo;
import com.codechallenge.demo.registry.TransactionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;

    public List<AccountDTO> getAccount() {
        List<Account> accounts;
        try {
            accounts = accountRepo.findAll();
        } catch (Exception e) {
            throw new AccountFetchException("Cannot fetch account from database!");
        }
        return accounts.stream().map(AccountConverter::convert).collect(Collectors.toList());
    }

    public List<TransactionDTO> getAccountTransaction(Long accountId) {
        List<Transaction> transactions;
        try {
            if (accountId != null) {
                Account account = new Account();
                account.setId(accountId);
                transactions = transactionRepo.findAllByAccount(account);
            } else {
                transactions = transactionRepo.findAll();
            }
        } catch (Exception e) {
            throw new AccountTransactionFetchException("Cannot fetch account transaction from database!");
        }
        return transactions.stream().map(TransactionConverter::convert).collect(Collectors.toList());
    }
}
