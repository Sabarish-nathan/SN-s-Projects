package com.prjgrp.artf.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fitness_tracker")
public class FitnessTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userEmail;

    private int stepsCount;

    private double caloriesBurned;

    private double distanceCovered;
}
