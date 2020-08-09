package com.codechallenge.demo.registry;

import com.codechallenge.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
