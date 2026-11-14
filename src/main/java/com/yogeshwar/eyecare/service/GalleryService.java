package com.yogeshwar.eyecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogeshwar.eyecare.entity.Gallery;
import com.yogeshwar.eyecare.repository.GalleryRepository;

@Service
public class GalleryService {

    private final GalleryRepository galleryRepository;

    public GalleryService(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    public List<Gallery> getAllActiveImages() {
        return galleryRepository.findByActiveTrue();
    }

    public List<Gallery> getAllImages() {
        return galleryRepository.findAll();
    }

    public Gallery addImage(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public Gallery updateImage(Long id, Gallery updatedGallery) {

        Gallery existingGallery = galleryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gallery image not found"));

        existingGallery.setTitle(updatedGallery.getTitle());
        existingGallery.setCategory(updatedGallery.getCategory());
        existingGallery.setImageUrl(updatedGallery.getImageUrl());
        existingGallery.setActive(updatedGallery.isActive());

        return galleryRepository.save(existingGallery);
    }

    public void deleteImage(Long id) {

        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gallery image not found"));

        galleryRepository.delete(gallery);
    }
}