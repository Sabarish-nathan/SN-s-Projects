package com.prjgrp.artf.repository;

import com.prjgrp.artf.model.YogaClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface YogaClassRepository extends JpaRepository<YogaClass, Long> {

    @Query("SELECT y FROM YogaClass y WHERE y.name = :name")
    YogaClass findByName(String name);

    @Query("SELECT y FROM YogaClass y")
    Page<YogaClass> findAllYogaClasses(Pageable pageable);
}
