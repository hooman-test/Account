package com.codechallenge.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@Data
@AllArgsConstructor
@Builder
public class AmountDTO {
    private BigDecimal amount;
    private Currency currency;
}
