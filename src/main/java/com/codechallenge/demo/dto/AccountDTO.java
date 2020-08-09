package com.codechallenge.demo.dto;

import com.codechallenge.demo.entity.AccountType;
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
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private String accountName;
    private AccountType type;
    private LocalDate balanceDate;
    private AmountDTO balance;
}
