package com.yeswanth.doctor.dto;

import com.yeswanth.doctor.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorDtoTests {

    @DisplayName("DTO : Checking")
    @Test
    void testObjectCreation() {

         Long id = 101l;
         String name = "chandu";
         String specialization = "dentist";
         String hospitalName = "MIMS";
         String hospitalLocality = "Vzm";
         boolean visiting = true;

        DoctorDto doc = new DoctorDto(id,name,specialization,hospitalName,hospitalLocality,visiting);

        long result = doc.getId();
        Assertions.assertEquals(id, result);

        String result2 = doc.getName();
        Assertions.assertEquals(name, result2);

        String result3 = doc.getSpecialization();
        Assertions.assertEquals(specialization, result3);

        String result4 = doc.getHospitalLocality();
        Assertions.assertEquals(hospitalLocality, result4);

        String result5 = doc.getHospitalName();
        Assertions.assertEquals(hospitalName, result5);

        boolean result6 = doc.isVisiting();
        Assertions.assertEquals(result6, visiting);

        Assertions.assertNotNull(doc);
    }

    @DisplayName("DTO : Checking Getters")
    @Test
    void testObjectGetters() {

        var doc = new Doctor();
        doc.setId(10L);
        doc.setName("chandu");
        doc.setSpecialization("dentist");
        doc.setHospitalName("sri venkateshwara hospital");
        doc.setHospitalLocality("vizianagaram");
        doc.setVisiting(true);

        assertEquals(10,doc.getId());
        assertEquals("chandu",doc.getName());
        assertEquals("dentist",doc.getSpecialization());
        assertEquals("sri venkateshwara hospital",doc.getHospitalName());
        assertEquals("vizianagaram",doc.getHospitalLocality());
        assertEquals(true,doc.isVisiting());

    }

}
