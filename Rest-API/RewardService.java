package com.prjgrp.artf.service;

import com.prjgrp.artf.model.Reward;
import com.prjgrp.artf.repository.RewardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    private final RewardRepository rewardRepository;

    public RewardService(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    public Page<Reward> getAllRewards(Pageable pageable) {
        return rewardRepository.findAllRewards(pageable);
    }

    public Reward getRewardByName(String rewardName) {
        return rewardRepository.findByRewardName(rewardName);
    }

    public Reward addReward(Reward reward) {
        return rewardRepository.save(reward);
    }
}
