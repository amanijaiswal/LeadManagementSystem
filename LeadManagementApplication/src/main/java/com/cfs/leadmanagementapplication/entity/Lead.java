package com.cfs.leadmanagementapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "leads")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    private String company;

    @Column(columnDefinition = "TEXT")
    private String requirement;

    private LocalDateTime submittedTime;

    private boolean emailSent;

    private boolean emailOpened;

    private boolean linkClicked;

    @PrePersist
    public void prePersist() {
        this.submittedTime = LocalDateTime.now();
        this.emailSent = false;
        this.emailOpened = false;
        this.linkClicked = false;
    }
}