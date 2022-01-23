package com.yeswanth.doctor.service;

import com.yeswanth.doctor.domain.Doctor;
import com.yeswanth.doctor.dto.DoctorDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DoctorServiceImpTests {


    @Autowired
    private DoctorService service;

    @DisplayName("Testing doctor by specialization :")
    @Test
    public void testDoctorFindBySpec(){
        var op = service.findVisitingDoctorBySpecialization("Psychiatry");
        Assertions.assertNotNull(op);
    }

    @DisplayName("Testing  Doctor by locality")
    @Test
    public void testDoctorFindByloc(){
        var op = service.doctorLocality("vizag");
        Assertions.assertNotNull(op);
    }

    @DisplayName("Testing  Doctor for  deleteDoctor")
    @Test
    public void testDeleteDoctor(){
       var op = service.deleteDoctor("naidu");
        Assertions.assertNotNull(op);
    }

}
