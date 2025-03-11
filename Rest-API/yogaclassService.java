package com.prjgrp.artf.service;

import com.prjgrp.artf.model.YogaClass;
import com.prjgrp.artf.repository.YogaClassRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class yogaclassService {

    private final YogaClassRepository yogaClassRepository;

    public yogaclassService(YogaClassRepository yogaClassRepository) {
        this.yogaClassRepository = yogaClassRepository;
    }

    public YogaClass createYogaClass(YogaClass yogaClass) {
        return yogaClassRepository.save(yogaClass);
    }

    public YogaClass getYogaClassByName(String name) {
        return yogaClassRepository.findByName(name);
    }

    public Page<YogaClass> getAllYogaClasses(Pageable pageable) {
        return yogaClassRepository.findAllYogaClasses(pageable);
    }

    public YogaClass updateYogaClass(String name, YogaClass updatedYogaClass) {
        YogaClass existingYogaClass = yogaClassRepository.findByName(name);
        if (existingYogaClass != null) {
            existingYogaClass.setDescription(updatedYogaClass.getDescription());
            return yogaClassRepository.save(existingYogaClass);
        }
        return null;
    }

    public void deleteYogaClass(String name) {
        YogaClass existingYogaClass = yogaClassRepository.findByName(name);
        if (existingYogaClass != null) {
            yogaClassRepository.delete(existingYogaClass);
        }
    }
}
