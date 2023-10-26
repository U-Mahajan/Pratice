package com.college.Employee.exception;

import lombok.Data;

import java.util.Date;

@Data
public class Error {
    private Date timestamp;
    private String message;
    private String details;

    public Error(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }


}
