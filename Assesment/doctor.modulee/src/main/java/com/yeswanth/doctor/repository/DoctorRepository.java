package com.yeswanth.doctor.repository;

import com.yeswanth.doctor.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByHospitalLocality(String pre);


    List<Doctor> deleteByHospitalName(String name);


    List<Doctor> findAll();



}
