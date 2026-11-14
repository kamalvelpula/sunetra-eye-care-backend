
package com.yogeshwar.eyecare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogeshwar.eyecare.entity.Service;
import com.yogeshwar.eyecare.service.ServiceService;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:5173")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getAllServices() {
        return serviceService.getAllServices();
    }

    @PostMapping
    public Service saveService(@RequestBody Service service) {
        return serviceService.saveService(service);
    }

    @PutMapping("/{id}")
    public Service updateService(
            @PathVariable Long id,
            @RequestBody Service service) {

        return serviceService.updateService(id, service);
    }

    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return "Service deleted successfully";
    }
}