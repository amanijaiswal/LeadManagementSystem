package com.cfs.leadmanagementapplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LeadRequest {

    @NotBlank(message = "Name is required")
    private String fullName;

    @Email
    private String email;

    @NotBlank
    private String phone;

    private String company;

    @NotBlank
    private String requirement;

}