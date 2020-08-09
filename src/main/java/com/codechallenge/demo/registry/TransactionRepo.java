package com.codechallenge.demo.registry;

import com.codechallenge.demo.entity.Account;
import com.codechallenge.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccount(Account account);
}
