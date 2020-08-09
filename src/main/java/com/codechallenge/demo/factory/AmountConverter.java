package com.codechallenge.demo.factory;

import com.codechallenge.demo.dto.AmountDTO;
import com.codechallenge.demo.entity.Amount;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AmountConverter {
    public static AmountDTO convert(Amount amount) {
        return AmountDTO.builder()
                .amount(amount.getValue())
                .currency(amount.getCurrency())
                .build();
    }
}
