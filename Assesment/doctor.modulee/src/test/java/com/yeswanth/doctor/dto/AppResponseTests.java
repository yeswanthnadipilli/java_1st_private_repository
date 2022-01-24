package com.yeswanth.doctor.dto;

import com.yeswanth.doctor.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppResponseTests {

    @DisplayName("AppResponse Object Checking")
    @Test
    void testObjectCreation() {

        AppResponse ap = new AppResponse();
        Assertions.assertNotNull(ap);
    }



}
