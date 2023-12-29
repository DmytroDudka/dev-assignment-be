package com.transferz.exception;

public class FlightException extends RuntimeException {

    public static final String NOT_FOUND = "Flight not found!";
    public static final String ALREADY_REGISTERED = "User is already registered for this flight";

    public FlightException(String message) {
        super(message);
    }
}
