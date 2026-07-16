package com.example.reactiveratingservice.exception;

public class RatingNotFoundException extends Exception {

    public RatingNotFoundException(String code) {

        super(String.format("Rating not found: %s", code));

    }

}
