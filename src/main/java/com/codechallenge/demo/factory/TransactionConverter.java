package com.codechallenge.demo.factory;

import com.codechallenge.demo.dto.TransactionDTO;
import com.codechallenge.demo.entity.Transaction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionConverter {
    public static TransactionDTO convert(Transaction t) {
        return TransactionDTO.builder()
                .id(t.getId())
                .account(AccountConverter.convert(t.getAccount()))
                .amount(AmountConverter.convert(t.getAmount()))
                .amountType(t.getAmountType())
                .date(t.getDate())
                .narrative(t.getNarrative())
                .build();
    }
}
