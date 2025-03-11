package com.prjgrp.artf.repository;

import com.prjgrp.artf.model.Reward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {

    @Query("SELECT r FROM Reward r WHERE r.rewardName = :rewardName")
    Reward findByRewardName(String rewardName);

    @Query("SELECT r FROM Reward r")
    Page<Reward> findAllRewards(Pageable pageable);
}
