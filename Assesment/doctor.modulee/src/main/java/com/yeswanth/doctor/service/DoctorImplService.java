package com.yeswanth.doctor.service;

import com.yeswanth.doctor.domain.Doctor;
import com.yeswanth.doctor.dto.DoctorDto;
import com.yeswanth.doctor.exception.InvalidIdException;
import com.yeswanth.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class DoctorImplService implements DoctorService {

    @Autowired
    private DoctorRepository repository;


    @Override
    public DoctorDto createDoctor(DoctorDto dto) {

        var doctor = new Doctor();
        doctor.setId(dto.getId());
        doctor.setName(dto.getName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setHospitalName(dto.getHospitalName());
        doctor.setHospitalLocality(dto.getHospitalLocality());
        doctor.setVisiting(dto.isVisiting());
        repository.save(doctor);
         return dto;
    }


    public DoctorDto updateDoctorById(DoctorDto dto) throws InvalidIdException {

        Doctor doctor = repository.findById(dto.getId()).orElseThrow(() -> new InvalidIdException("Enter valid Id"));
        var doc = new Doctor();
        doc.setId(dto.getId());
        doc.setName(dto.getName());
        doc.setSpecialization(dto.getSpecialization());
        doc.setHospitalName(dto.getHospitalName());
        doc.setHospitalLocality(dto.getHospitalLocality());
        doc.setVisiting(dto.isVisiting());
        repository.save(doc);
        return dto;


    }


    @Override
    public List<Doctor> doctorLocality(String pre) {

        return repository.findByHospitalLocality(pre);
    }



    @Transactional
    @Override
    public List<Doctor> deleteDoctor(String name) {

        return repository.deleteByHospitalName(name);
    }



    @Override
    public List<DoctorDto> findVisitingDoctorBySpecialization(String spec) {

        List<Doctor> dto = repository.findAll();
        List<DoctorDto> dto1 = dto.stream()
                .filter(n-> n.isVisiting()== true  && n.getSpecialization().equals(spec))
                .map (doc -> new DoctorDto(
                        doc.getId(),
                        doc.getName(),
                        doc.getSpecialization(),
                        doc.getHospitalName(),
                        doc.getHospitalLocality(),
                        doc.isVisiting()
                ))
                .collect(Collectors.toList());
        return dto1;
    }




}
