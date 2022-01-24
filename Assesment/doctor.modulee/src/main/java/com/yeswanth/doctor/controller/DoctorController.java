package com.yeswanth.doctor.controller;


import com.yeswanth.doctor.domain.Doctor;
import com.yeswanth.doctor.dto.AppResponse;
import com.yeswanth.doctor.dto.DoctorDto;
import com.yeswanth.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequestMapping("/doctor")
@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping // POST ->  http://localhost:8080/doctor/
    public ResponseEntity<AppResponse<DoctorDto>> createDoctor(@RequestBody DoctorDto dto) {

        var svObj = service.createDoctor(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor saved successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AppResponse<DoctorDto>> updateDoctorById(@RequestBody DoctorDto dto) {
        var svObj = service.updateDoctorById(dto);
        var response = new AppResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor info updated successfully");
        response.setBody(svObj);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<AppResponse<List<Doctor>>> locality(@RequestBody DoctorDto dto) {

        var obj = service.doctorLocality(dto.getHospitalLocality());
        var response = new AppResponse<List<Doctor>>();
        response.setMessage("account list");
        response.setStatus("success");
        response.setBody(obj);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping
    public ResponseEntity<AppResponse<List<Doctor>>> deleteOperation(@RequestBody DoctorDto dto) {

        List<Doctor> obj1 = service.deleteDoctor(dto.getHospitalName());
        var response = new AppResponse<List<Doctor>>();
        response.setMessage("doctor deleted successfully");
        response.setStatus("success");
        response.setBody(obj1);
        return ResponseEntity.ok(response);
    }





    @GetMapping("/{Specialization}")
    public ResponseEntity<AppResponse<List<DoctorDto>>> findVisitingDoctorBySpecialization(@PathVariable String Specialization){

        var svObj = service.findVisitingDoctorBySpecialization(Specialization);
        var response = new AppResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }


}

