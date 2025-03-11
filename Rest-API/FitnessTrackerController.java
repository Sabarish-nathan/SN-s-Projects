package com.prjgrp.artf.controller;
import com.prjgrp.artf.model.FitnessTracker;
import com.prjgrp.artf.service.FitnessTrackerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fitness-tracker")
public class FitnessTrackerController {

    private final FitnessTrackerService fitnessTrackerService;

    public FitnessTrackerController(FitnessTrackerService fitnessTrackerService) {
        this.fitnessTrackerService = fitnessTrackerService;
    }

    @PostMapping
    public ResponseEntity<FitnessTracker> createFitnessData(@RequestBody FitnessTracker fitnessTracker) {
        return ResponseEntity.status(201).body(fitnessTrackerService.createFitnessData(fitnessTracker));
    }

    @GetMapping("/{email}")
    public ResponseEntity<FitnessTracker> getFitnessDataByEmail(@PathVariable String email) {
        FitnessTracker fitnessData = fitnessTrackerService.getFitnessDataByEmail(email);
        return fitnessData != null ? ResponseEntity.ok(fitnessData) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<FitnessTracker>> getAllFitnessData(Pageable pageable) {
        return ResponseEntity.ok(fitnessTrackerService.getAllFitnessData(pageable));
    }

    @PutMapping("/{email}")
    public ResponseEntity<FitnessTracker> updateFitnessData(@PathVariable String email, @RequestBody FitnessTracker fitnessTracker) {
        FitnessTracker updatedData = fitnessTrackerService.updateFitnessData(email, fitnessTracker);
        return updatedData != null ? ResponseEntity.ok(updatedData) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteFitnessData(@PathVariable String email) {
        fitnessTrackerService.deleteFitnessData(email);
        return ResponseEntity.noContent().build();
    }
}
