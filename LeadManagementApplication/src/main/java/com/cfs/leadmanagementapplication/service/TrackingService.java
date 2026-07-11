package com.cfs.leadmanagementapplication.service;

import com.cfs.leadmanagementapplication.entity.EmailTracking;
import com.cfs.leadmanagementapplication.entity.Lead;
import com.cfs.leadmanagementapplication.repository.EmailTrackingRepository;
import com.cfs.leadmanagementapplication.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TrackingService {

    @Autowired
    private EmailTrackingRepository trackingRepository;

    @Autowired
    private LeadRepository leadRepository;

    public void emailOpened(String token) {

        EmailTracking tracking = trackingRepository
                .findByTrackingToken(token)
                .orElse(null);

        if (tracking == null)
            return;

        if (!tracking.isOpened()) {

            tracking.setOpened(true);
            tracking.setOpenedTime(LocalDateTime.now());

            Lead lead = tracking.getLead();
            lead.setEmailOpened(true);

            leadRepository.save(lead);
            trackingRepository.save(tracking);
        }
    }

    public String emailClicked(String token) {

        EmailTracking tracking = trackingRepository
                .findByTrackingToken(token)
                .orElse(null);

        if (tracking == null)
            return "https://google.com";

        if (!tracking.isClicked()) {

            tracking.setClicked(true);
            tracking.setClickedTime(LocalDateTime.now());

            Lead lead = tracking.getLead();
            lead.setLinkClicked(true);

            leadRepository.save(lead);
            trackingRepository.save(tracking);
        }

        return "https://google.com";
    }
}