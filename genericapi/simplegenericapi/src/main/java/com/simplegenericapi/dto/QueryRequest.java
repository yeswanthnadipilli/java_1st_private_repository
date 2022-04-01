package com.simplegenericapi.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QueryRequest {
    private String query;
    private Object[] params;
    private int[] paramType;

}
