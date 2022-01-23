package com.yeswanth.doctor.repository;


import com.yeswanth.doctor.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorRepositoryTests {

    @Autowired
    private DoctorRepository repository;


    @DisplayName("Testing create Doctor")
    @Test
    public void testCreateDoctor() {
        Doctor dto = new Doctor();
        dto.setId(100l);
        dto.setName("yeswanth");
        dto.setSpecialization("dentist");
        dto.setHospitalName("Mims");
        dto.setHospitalLocality("vizag");
        dto.setVisiting(true);

        Doctor dt = repository.save(dto);

        Assertions.assertNotNull(dt);
    }

    @DisplayName("Testing delete doctor")
    @Test
    public void testDeleteDoctor() {
       List<Doctor> dt = repository.deleteByHospitalName("Medicover Hospital");
       Assertions.assertNotNull(dt);
    }

    @DisplayName("Testing doctor by locality")
    @Test
    public void testDoctorFindByloc(){
        var op = repository.findByHospitalLocality("vizag");
        Assertions.assertNotNull(op);
    }


}




