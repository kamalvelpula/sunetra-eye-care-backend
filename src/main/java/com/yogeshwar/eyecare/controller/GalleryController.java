package com.yogeshwar.eyecare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yogeshwar.eyecare.entity.Gallery;
import com.yogeshwar.eyecare.service.GalleryService;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "http://localhost:5173")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    // Public: Get active gallery images
    @GetMapping
    public ResponseEntity<List<Gallery>> getAllActiveImages() {
        return ResponseEntity.ok(galleryService.getAllActiveImages());
    }

    // Admin: Get all gallery images
    @GetMapping("/admin")
    public ResponseEntity<List<Gallery>> getAllImages() {
        return ResponseEntity.ok(galleryService.getAllImages());
    }

    // Admin: Add gallery image
    @PostMapping
    public ResponseEntity<Gallery> addImage(@RequestBody Gallery gallery) {
        return ResponseEntity.ok(galleryService.addImage(gallery));
    }

    // Admin: Update gallery image
    @PutMapping("/{id}")
    public ResponseEntity<Gallery> updateImage(
            @PathVariable Long id,
            @RequestBody Gallery gallery) {

        return ResponseEntity.ok(galleryService.updateImage(id, gallery));
    }

    // Admin: Delete gallery image
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {

        galleryService.deleteImage(id);

        return ResponseEntity.ok("Gallery image deleted successfully");
    }
}