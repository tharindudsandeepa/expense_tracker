package org.tharindu.expense.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorObJect {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}
