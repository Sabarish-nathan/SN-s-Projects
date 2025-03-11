package com.prjgrp.artf.controller;

import com.prjgrp.artf.model.Challenge;
import com.prjgrp.artf.service.ChallengeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping
    public ResponseEntity<Challenge> createChallenge(@RequestBody Challenge challenge) {
        return ResponseEntity.status(201).body(challengeService.createChallenge(challenge));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Challenge> getChallengeByName(@PathVariable String name) {
        Challenge challenge = challengeService.getChallengeByName(name);
        return challenge != null ? ResponseEntity.ok(challenge) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<Challenge>> getAllChallenges(Pageable pageable) {
        return ResponseEntity.ok(challengeService.getAllChallenges(pageable));
    }
    
    @PutMapping("/{name}")
    public ResponseEntity<Challenge> updateChallenge(@PathVariable String name, @RequestBody Challenge updatedChallenge) {
        Challenge challenge = challengeService.updateChallenge(name, updatedChallenge);
        return challenge != null ? ResponseEntity.ok(challenge) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable String name) {
        challengeService.deleteChallenge(name);
        return ResponseEntity.noContent().build();
    }
}
