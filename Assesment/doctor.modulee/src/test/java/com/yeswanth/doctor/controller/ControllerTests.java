package com.yeswanth.doctor.controller;


import com.yeswanth.doctor.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTests {


    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;

    @Test
    public void testGetMethod() {

        String url = "http://" + "localhost" + ":" + port + "/doctor";
        Doctor doc = template.getForObject(url, Doctor.class);
        Assertions.assertNotNull(doc);
    }


        @DisplayName("Testing Post method for saving")
        @Test
        public void testPostMethod(){
            String url = "http://"+"localhost"+":"+port+"/doctor";
            var doctor = new Doctor();
            doctor.setId(17L);
            doctor.setName("kranthi");
            doctor.setSpecialization("opera");
            doctor.setHospitalName("hosp");
            doctor.setHospitalLocality("us");
            doctor.setVisiting(true);
            var re =template.postForEntity(url,doctor,Doctor.class);
            Assertions.assertEquals(HttpStatus.OK , re.getStatusCode());
        }

    }
