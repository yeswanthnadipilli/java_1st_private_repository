package com.simplegenericapi.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseApi <T> {
    private T body;
    private String status;
    private String message;
    private String httpStatusCode;


}
