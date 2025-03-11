package com.prjgrp.artf.service;

import com.prjgrp.artf.model.FitnessTracker;
import com.prjgrp.artf.repository.FitnessTrackerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FitnessTrackerService {

    private final FitnessTrackerRepository fitnessTrackerRepository;

    public FitnessTrackerService(FitnessTrackerRepository fitnessTrackerRepository) {
        this.fitnessTrackerRepository = fitnessTrackerRepository;
    }

    public FitnessTracker createFitnessData(FitnessTracker fitnessTracker) {
        return fitnessTrackerRepository.save(fitnessTracker);
    }

    public FitnessTracker getFitnessDataByEmail(String email) {
        return fitnessTrackerRepository.findByUserEmail(email);
    }

    public Page<FitnessTracker> getAllFitnessData(Pageable pageable) {
        return fitnessTrackerRepository.findAllFitnessData(pageable);
    }

    public FitnessTracker updateFitnessData(String email, FitnessTracker updatedData) {
        FitnessTracker existingData = fitnessTrackerRepository.findByUserEmail(email);
        if (existingData != null) {
            existingData.setStepsCount(updatedData.getStepsCount());
            existingData.setCaloriesBurned(updatedData.getCaloriesBurned());
            existingData.setDistanceCovered(updatedData.getDistanceCovered());
            return fitnessTrackerRepository.save(existingData);
        }
        return null;
    }

    public void deleteFitnessData(String email) {
        FitnessTracker existingData = fitnessTrackerRepository.findByUserEmail(email);
        if (existingData != null) {
            fitnessTrackerRepository.delete(existingData);
        }
    }
}
