package com.simplejdbcapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Getter
    @Setter
    @NoArgsConstructor
    public class QueryResponse {
        private String searchQuery;
        private String query;
        private Object Param;
    }

