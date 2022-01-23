package com.yeswanth.doctor.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DoctorTests {

    @DisplayName("Domain : Checking")
    @Test
    void testObjectCreation() {
        var doc = new Doctor();
        Assertions.assertNotNull(doc);
    }

    @DisplayName("Domain : Checking Getters")
    @Test
    void testObjectGetters() {

        var doc = new Doctor();
        doc.setId(10L);
        doc.setName("yeswanth");
        doc.setSpecialization("Psychiatry");
        doc.setHospitalName("sri venkateshwara hospital");
        doc.setHospitalLocality("vizianagaram");
        doc.setVisiting(true);

        Assertions.assertEquals(10,doc.getId());
        Assertions.assertEquals("yeswanth",doc.getName());
        Assertions.assertEquals("Psychiatry",doc.getSpecialization());
        Assertions.assertEquals("sri venkateshwara hospital",doc.getHospitalName());
        Assertions.assertEquals("vizianagaram",doc.getHospitalLocality());
        Assertions.assertEquals(true,doc.isVisiting());

    }

}
