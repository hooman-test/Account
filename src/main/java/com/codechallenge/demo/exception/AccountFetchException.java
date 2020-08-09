package com.codechallenge.demo.exception;

/**
 * @author Hooman Noroozinia
 * @since 8/8/20
 */
public class AccountFetchException extends RuntimeException {

    public AccountFetchException() {
    }

    public AccountFetchException(String message) {
        super(message);
    }
}
