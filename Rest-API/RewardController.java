package com.prjgrp.artf.controller;

import com.prjgrp.artf.model.Reward;
import com.prjgrp.artf.service.RewardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rewards")
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public Page<Reward> getAllRewards(Pageable pageable) {
        return rewardService.getAllRewards(pageable);
    }

    @GetMapping("/{rewardName}")
    public Reward getRewardByName(@PathVariable String rewardName) {
        return rewardService.getRewardByName(rewardName);
    }

    @PostMapping
    public Reward addReward(@RequestBody Reward reward) {
        return rewardService.addReward(reward);
    }
}
