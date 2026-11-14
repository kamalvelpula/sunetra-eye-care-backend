
package com.yogeshwar.eyecare.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.yogeshwar.eyecare.entity.ContactMessage;
import com.yogeshwar.eyecare.exception.ResourceNotFoundException;
import com.yogeshwar.eyecare.repository.ContactMessageRepository;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public ContactMessage saveMessage(ContactMessage contactMessage) {
        contactMessage.setStatus("NEW");
        return contactMessageRepository.save(contactMessage);
    }

    public List<ContactMessage> getAllMessages() {
        return contactMessageRepository.findAll();
    }

    public ContactMessage getMessageById(Long id) {
        return contactMessageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Message not found with ID: " + id));
    }

    // Admin API - Update contact message status
    public ContactMessage updateMessageStatus(Long id, String status) {

        ContactMessage contactMessage = getMessageById(id);

        Set<String> allowedStatuses = Set.of("NEW", "READ", "REPLIED");

        String updatedStatus = status.trim().toUpperCase();

        if (!allowedStatuses.contains(updatedStatus)) {
            throw new IllegalArgumentException(
                    "Invalid status! Allowed statuses: NEW, READ, REPLIED");
        }

        contactMessage.setStatus(updatedStatus);

        return contactMessageRepository.save(contactMessage);
    }

    // Admin API - Delete contact message
    public void deleteMessage(Long id) {
        ContactMessage contactMessage = getMessageById(id);
        contactMessageRepository.delete(contactMessage);
    }
}