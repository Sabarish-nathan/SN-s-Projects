package com.prjgrp.artf.service;

import com.prjgrp.artf.model.Challenge;
import com.prjgrp.artf.repository.ChallengeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public Challenge getChallengeByName(String name) {
        return challengeRepository.findByName(name);
    }

    public Page<Challenge> getAllChallenges(Pageable pageable) {
        return challengeRepository.findAllChallenges(pageable);
    }

    public Challenge updateChallenge(String name, Challenge updatedChallenge) {
        Challenge existingChallenge = challengeRepository.findByName(name);
        if (existingChallenge != null) {
            existingChallenge.setDescription(updatedChallenge.getDescription());
            existingChallenge.setDurationInDays(updatedChallenge.getDurationInDays());
            return challengeRepository.save(existingChallenge);
        }
        return null;
    }

    public void deleteChallenge(String name) {
        Challenge existingChallenge = challengeRepository.findByName(name);
        if (existingChallenge != null) {
            challengeRepository.delete(existingChallenge);
        }
    }
}
