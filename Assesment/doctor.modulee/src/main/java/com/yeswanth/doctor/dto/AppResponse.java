package com.yeswanth.doctor.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppResponse<Doctor> {
    private String status;
    private String message;
    private Doctor body;


}
