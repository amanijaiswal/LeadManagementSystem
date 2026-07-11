package com.cfs.leadmanagementapplication.controller;

import com.cfs.leadmanagementapplication.entity.Lead;
import com.cfs.leadmanagementapplication.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public Lead saveLead(@Valid @RequestBody Lead lead) {
        return leadService.saveLead(lead);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @GetMapping("/{id}")
    public Lead getLead(@PathVariable Long id) {
        return leadService.getLeadById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteLead(@PathVariable Long id) {

        leadService.deleteLead(id);

        return "Lead Deleted Successfully";
    }

}