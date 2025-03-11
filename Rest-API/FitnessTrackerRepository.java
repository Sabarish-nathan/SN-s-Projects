package com.prjgrp.artf.repository;

import com.prjgrp.artf.model.FitnessTracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessTrackerRepository extends JpaRepository<FitnessTracker, Long> {

    @Query("SELECT f FROM FitnessTracker f WHERE f.userEmail = :email")
    FitnessTracker findByUserEmail(String email);

    @Query("SELECT f FROM FitnessTracker f")
    Page<FitnessTracker> findAllFitnessData(Pageable pageable);
}
