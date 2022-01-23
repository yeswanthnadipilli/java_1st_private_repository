package com.yeswanth.doctor.service;

import com.yeswanth.doctor.domain.Doctor;
import com.yeswanth.doctor.dto.DoctorDto;
import com.yeswanth.doctor.exception.InvalidIdException;

import java.util.List;

public interface DoctorService {

    public DoctorDto createDoctor(DoctorDto dto);

    public List<Doctor> doctorLocality(String pre);

    public List<Doctor> deleteDoctor(String name);



    public List<DoctorDto> findVisitingDoctorBySpecialization(String spec);

    public DoctorDto updateDoctorById(DoctorDto dto) throws InvalidIdException;

}
