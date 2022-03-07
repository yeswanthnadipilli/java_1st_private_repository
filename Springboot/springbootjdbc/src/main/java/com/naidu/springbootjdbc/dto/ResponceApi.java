package com.naidu.springbootjdbc.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceApi <T> {

    private String status;
    private String message;
    private String httpStatusCode;
    private T body;
}
