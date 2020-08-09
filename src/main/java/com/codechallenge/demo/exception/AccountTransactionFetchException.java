package com.codechallenge.demo.exception;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
public class AccountTransactionFetchException extends RuntimeException {

    public AccountTransactionFetchException() {
    }

    public AccountTransactionFetchException(String message) {
        super(message);
    }
}
