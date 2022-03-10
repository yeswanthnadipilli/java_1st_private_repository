package com.simplejdbcapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



    import lombok.*;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ResponseApi <T> {

        private String status;
        private String message;
        private String httpStatusCode;
        private T body;
    }

