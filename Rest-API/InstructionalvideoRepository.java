package com.prjgrp.artf.repository;

import com.prjgrp.artf.model.InstructionalVideo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionalvideoRepository extends JpaRepository<InstructionalVideo, Long> {

    @Query("SELECT v FROM InstructionalVideo v WHERE v.title = :title")
    InstructionalVideo findByTitle(String title);

    @Query("SELECT v FROM InstructionalVideo v")
    Page<InstructionalVideo> findAllVideos(Pageable pageable);
}
