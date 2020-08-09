package com.codechallenge.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Amount {
    private BigDecimal value;
    private Currency currency;
}
