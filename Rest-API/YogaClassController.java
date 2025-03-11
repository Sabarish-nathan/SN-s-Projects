package com.prjgrp.artf.controller;

import com.prjgrp.artf.model.YogaClass;
import com.prjgrp.artf.service.yogaclassService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
public class YogaClassController {

    private final yogaclassService yogaClassService;

    public YogaClassController(yogaclassService yogaClassService) {
        this.yogaClassService = yogaClassService;
    }

    @PostMapping
    public ResponseEntity<YogaClass> createYogaClass(@RequestBody YogaClass yogaClass) {
        return ResponseEntity.status(201).body(yogaClassService.createYogaClass(yogaClass));
    }

    @GetMapping("/{name}")
    public ResponseEntity<YogaClass> getYogaClassByName(@PathVariable String name) {
        YogaClass yogaClass = yogaClassService.getYogaClassByName(name);
        return yogaClass != null ? ResponseEntity.ok(yogaClass) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<YogaClass>> getAllYogaClasses(Pageable pageable) {
        return ResponseEntity.ok(yogaClassService.getAllYogaClasses(pageable));
    }

    @PutMapping("/{name}")
    public ResponseEntity<YogaClass> updateYogaClass(@PathVariable String name, @RequestBody YogaClass yogaClass) {
        YogaClass updatedClass = yogaClassService.updateYogaClass(name, yogaClass);
        return updatedClass != null ? ResponseEntity.ok(updatedClass) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteYogaClass(@PathVariable String name) {
        yogaClassService.deleteYogaClass(name);
        return ResponseEntity.noContent().build();
    }
}
