package com.yogeshwar.eyecare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.yogeshwar.eyecare.dto.AppointmentRequest;
import com.yogeshwar.eyecare.entity.Appointment;
import com.yogeshwar.eyecare.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Public API - Book appointment
    @PostMapping
    public Appointment bookAppointment(
            @Valid @RequestBody AppointmentRequest request) {

        Appointment appointment = new Appointment();

        appointment.setCustomerName(request.getCustomerName());
        appointment.setPhoneNumber(request.getPhoneNumber());
        appointment.setEmail(request.getEmail());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setServiceType(request.getServiceType());
        appointment.setMessage(request.getMessage());

        return appointmentService.bookAppointment(appointment);
    }

    // Admin API - Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Admin API - Get appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // Admin API - Update appointment status
    @PutMapping("/{id}/status")
    public Appointment updateAppointmentStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return appointmentService.updateAppointmentStatus(id, status);
    }

    // Admin API - Delete appointment
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully";
    }
}