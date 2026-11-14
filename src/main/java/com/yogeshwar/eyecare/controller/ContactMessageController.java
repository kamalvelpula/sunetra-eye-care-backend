
package com.yogeshwar.eyecare.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.yogeshwar.eyecare.dto.ContactRequest;
import com.yogeshwar.eyecare.entity.ContactMessage;
import com.yogeshwar.eyecare.service.ContactMessageService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    public ContactMessageController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    // Public API - Submit contact message
    @PostMapping
    public ContactMessage saveMessage(
            @Valid @RequestBody ContactRequest request) {

        ContactMessage contactMessage = new ContactMessage();

        contactMessage.setName(request.getName());
        contactMessage.setEmail(request.getEmail());
        contactMessage.setPhoneNumber(request.getPhoneNumber());
        contactMessage.setSubject(request.getSubject());
        contactMessage.setMessage(request.getMessage());

        return contactMessageService.saveMessage(contactMessage);
    }

    // Admin API - Get all messages
    @GetMapping
    public List<ContactMessage> getAllMessages() {
        return contactMessageService.getAllMessages();
    }

    // Admin API - Get message by ID
    @GetMapping("/{id}")
    public ContactMessage getMessageById(@PathVariable Long id) {
        return contactMessageService.getMessageById(id);
    }

    // Admin API - Update message status
    @PutMapping("/{id}/status")
    public ResponseEntity<ContactMessage> updateMessageStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        ContactMessage updatedMessage =
                contactMessageService.updateMessageStatus(id, status);

        return ResponseEntity.ok(updatedMessage);
    }

    // Admin API - Delete message
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMessage(
            @PathVariable Long id) {

        contactMessageService.deleteMessage(id);

        return ResponseEntity.ok(
                Map.of("message", "Contact message deleted successfully!")
        );
    }
}