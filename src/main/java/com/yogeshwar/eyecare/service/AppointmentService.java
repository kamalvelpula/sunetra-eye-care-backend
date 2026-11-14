
package com.yogeshwar.eyecare.service;

import java.util.List;
import com.yogeshwar.eyecare.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.yogeshwar.eyecare.entity.Appointment;
import com.yogeshwar.eyecare.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("PENDING");
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with ID: " + id));
    }

    public Appointment updateAppointmentStatus(Long id, String status) {

        Appointment appointment = getAppointmentById(id);

        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status is required");
        }

        status = status.trim().toUpperCase();

        if (!status.matches("PENDING|CONFIRMED|COMPLETED|CANCELLED")) {
            throw new IllegalArgumentException(
                    "Invalid status. Allowed: PENDING, CONFIRMED, COMPLETED, CANCELLED");
        }

        appointment.setStatus(status);

        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        Appointment appointment = getAppointmentById(id);
        appointmentRepository.delete(appointment);
    }
    
    
}