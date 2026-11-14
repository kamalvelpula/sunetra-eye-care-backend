package com.yogeshwar.eyecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yogeshwar.eyecare.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}