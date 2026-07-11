package com.cfs.leadmanagementapplication.repository;

import com.cfs.leadmanagementapplication.entity.EmailTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailTrackingRepository extends JpaRepository<EmailTracking, Long> {

    Optional<EmailTracking> findByTrackingToken(String trackingToken);

}