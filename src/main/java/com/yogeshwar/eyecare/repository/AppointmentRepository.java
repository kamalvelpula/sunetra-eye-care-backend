package com.yogeshwar.eyecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yogeshwar.eyecare.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}