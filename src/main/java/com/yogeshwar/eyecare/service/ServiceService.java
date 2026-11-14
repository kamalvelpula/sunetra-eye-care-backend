package com.yogeshwar.eyecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogeshwar.eyecare.exception.ResourceNotFoundException;
import com.yogeshwar.eyecare.repository.ServiceRepository;

@Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<com.yogeshwar.eyecare.entity.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public com.yogeshwar.eyecare.entity.Service saveService(
            com.yogeshwar.eyecare.entity.Service service) {

        return serviceRepository.save(service);
    }

    public com.yogeshwar.eyecare.entity.Service updateService(
            Long id,
            com.yogeshwar.eyecare.entity.Service updatedService) {

        com.yogeshwar.eyecare.entity.Service existingService =
                serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Service not found with ID: " + id));

        existingService.setName(updatedService.getName());
        existingService.setDescription(updatedService.getDescription());
        existingService.setImageUrl(updatedService.getImageUrl());
        existingService.setActive(updatedService.isActive());

        return serviceRepository.save(existingService);
    }

    public void deleteService(Long id) {

        com.yogeshwar.eyecare.entity.Service existingService =
                serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Service not found with ID: " + id));

        serviceRepository.delete(existingService);
    }
}