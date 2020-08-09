package com.codechallenge.demo.factory;

import com.codechallenge.demo.dto.AccountDTO;
import com.codechallenge.demo.entity.Account;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountConverter {
    public static AccountDTO convert(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .accountName(account.getType() + "-" + account.getAccountNumber())
                .accountNumber(account.getAccountNumber())
                .balance(AmountConverter.convert(account.getBalance()))
                .balanceDate(account.getBalanceDate())
                .type(account.getType())
                .build();
    }
}
