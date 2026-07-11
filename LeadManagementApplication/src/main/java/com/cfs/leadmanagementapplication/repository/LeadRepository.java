package com.cfs.leadmanagementapplication.repository;

import com.cfs.leadmanagementapplication.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    Optional<Lead> findByEmail(String email);

    long countByEmailSentTrue();

    long countByEmailOpenedTrue();

    long countByLinkClickedTrue();
}