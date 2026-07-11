package com.cfs.leadmanagementapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {

    private long totalLeads;

    private long emailsSent;

    private long emailsOpened;

    private long linksClicked;

    private double openRate;

    private double clickRate;

}