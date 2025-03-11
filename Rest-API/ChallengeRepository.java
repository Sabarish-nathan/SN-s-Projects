package com.prjgrp.artf.repository;

import com.prjgrp.artf.model.Challenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    @Query("SELECT c FROM Challenge c WHERE c.name = :name")
    Challenge findByName(String name);

    @Query("SELECT c FROM Challenge c")
    Page<Challenge> findAllChallenges(Pageable pageable);
}
