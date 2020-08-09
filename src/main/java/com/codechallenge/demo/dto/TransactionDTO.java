package com.codechallenge.demo.dto;

import com.codechallenge.demo.entity.TransactionAmountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@Data
@AllArgsConstructor
@Builder
public class TransactionDTO {
    private Long id;
    private AccountDTO account;
    private LocalDate date;
    private AmountDTO amount;
    private TransactionAmountType amountType;
    private String narrative;
}
