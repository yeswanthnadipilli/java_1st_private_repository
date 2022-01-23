package com.yeswanth.doctor.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Setter
@Getter
public class DoctorDto {

    @NotNull
    private Long id;

   @NotNull
    @NotBlank
    private String name;

    private String specialization;

    @NotNull
    @NotBlank
    private String hospitalName;

    @NotNull
    @NotBlank
    private String hospitalLocality;

    private boolean visiting;



}
