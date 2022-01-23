package com.yeswanth.doctor.domain;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String specialization;

    @Column(unique = false, nullable = true)
    private String hospitalName;

    @Column(unique = true, nullable = true)
    private String hospitalLocality;

    @Column(nullable = false)
    private boolean visiting;


}
