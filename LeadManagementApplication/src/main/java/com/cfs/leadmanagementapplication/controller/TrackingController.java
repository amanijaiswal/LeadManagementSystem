package com.cfs.leadmanagementapplication.controller;

import com.cfs.leadmanagementapplication.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/track")
@CrossOrigin(origins = "*")
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @GetMapping("/open/{token}")
    public ResponseEntity<Void> trackOpen(@PathVariable String token) {

        trackingService.emailOpened(token);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/click/{token}")
    public ResponseEntity<Void> trackClick(@PathVariable String token) {

        String redirectUrl = trackingService.emailClicked(token);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", redirectUrl);

        return ResponseEntity.status(302)
                .headers(headers)
                .build();
    }

}