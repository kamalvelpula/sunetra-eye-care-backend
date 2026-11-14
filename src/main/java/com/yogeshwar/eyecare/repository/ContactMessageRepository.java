package com.yogeshwar.eyecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yogeshwar.eyecare.entity.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {

}