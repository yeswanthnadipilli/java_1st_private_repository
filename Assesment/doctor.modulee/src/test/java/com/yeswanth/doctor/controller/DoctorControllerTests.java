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
public class DoctorControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGetMethod() {

        String url = "http://" + "localhost" +":" + port +"/doctor";
        Doctor doc =  template.getForObject(url,Doctor.class);
        Assertions.assertNotNull(doc);
    }


    @DisplayName("Post Doctor saving Doctor Object")
    @Test
    public void testPostMethod() {
        String url = "http://" + "localhost" +":" + port +"/doctor";
        var doc = new Doctor();
        doc.setId(8l);
        doc.setName("tarun");
        doc.setSpecialization("fever");
        doc.setHospitalName("tarunRam");
        doc.setHospitalLocality("vzm");
        doc.setVisiting(true);
        var re = template.postForEntity(
                url,
                doc,
                Doctor.class
        );
        Assertions.assertEquals(HttpStatus.CREATED, re.getStatusCode());
    }



}



