package com.cfs.leadmanagementapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_tracking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "lead_id", nullable = false)
    private com.cfs.leadmanagementapplication.entity.Lead lead;

    @Column(nullable = false, unique = true)
    private String trackingToken;

    private boolean opened;

    private boolean clicked;

    private LocalDateTime openedTime;

    private LocalDateTime clickedTime;
}