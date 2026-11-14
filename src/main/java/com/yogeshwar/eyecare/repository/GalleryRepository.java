package com.yogeshwar.eyecare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yogeshwar.eyecare.entity.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {

    List<Gallery> findByActiveTrue();

}