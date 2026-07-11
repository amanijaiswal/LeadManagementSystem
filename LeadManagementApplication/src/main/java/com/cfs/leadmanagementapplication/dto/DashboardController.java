package com.cfs.leadmanagementapplication.dto;

import com.cfs.leadmanagementapplication.dto.DashboardDTO;
import com.cfs.leadmanagementapplication.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private LeadRepository leadRepository;

    @GetMapping
    public DashboardDTO dashboard() {

        long total = leadRepository.count();

        long sent = leadRepository.countByEmailSentTrue();

        long opened = leadRepository.countByEmailOpenedTrue();

        long clicked = leadRepository.countByLinkClickedTrue();

        double openRate = total == 0 ? 0 : (opened * 100.0) / total;

        double clickRate = total == 0 ? 0 : (clicked * 100.0) / total;

        return new DashboardDTO(
                total,
                sent,
                opened,
                clicked,
                openRate,
                clickRate
        );

    }

}