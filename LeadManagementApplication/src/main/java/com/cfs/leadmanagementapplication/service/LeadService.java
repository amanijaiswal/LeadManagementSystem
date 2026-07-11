package com.cfs.leadmanagementapplication.service;

import com.cfs.leadmanagementapplication.entity.EmailTracking;
import com.cfs.leadmanagementapplication.entity.Lead;
import com.cfs.leadmanagementapplication.repository.EmailTrackingRepository;
import com.cfs.leadmanagementapplication.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private EmailTrackingRepository trackingRepository;

    @Autowired
    private EmailService emailService;

    public Lead saveLead(Lead lead) {

        Lead savedLead = leadRepository.save(lead);

        String token = UUID.randomUUID().toString();

        EmailTracking tracking = EmailTracking.builder()
                .lead(savedLead)
                .trackingToken(token)
                .opened(false)
                .clicked(false)
                .build();

        trackingRepository.save(tracking);

        try {

            emailService.sendLeadEmail(savedLead, token);

            savedLead.setEmailSent(true);

        } catch (Exception e) {

            e.printStackTrace();

        }

        savedLead.setEmailSent(true);

        return leadRepository.save(savedLead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElse(null);
    }

    public void deleteLead(Long id) {
        leadRepository.deleteById(id);
    }
}