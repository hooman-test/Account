package com.codechallenge.demo.controller;

import com.codechallenge.demo.dto.AccountDTO;
import com.codechallenge.demo.dto.TransactionDTO;
import com.codechallenge.demo.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@RestController
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/account")
    public ResponseEntity<List<AccountDTO>> getAccountList() {
        List<AccountDTO> accounts;
        try {
            accounts = accountService.getAccount();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/account/transaction")
    public ResponseEntity<List<TransactionDTO>> getAccountTransactionList(@QueryParam(value = "accountId") Long accountId) {
        List<TransactionDTO> transactions;
        try {
            transactions = accountService.getAccountTransaction(accountId);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
