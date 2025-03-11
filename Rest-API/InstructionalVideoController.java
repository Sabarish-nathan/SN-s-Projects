package com.prjgrp.artf.controller;

import com.prjgrp.artf.model.InstructionalVideo;
import com.prjgrp.artf.service.InstructionalvideoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/videos")
public class InstructionalVideoController {

    private final InstructionalvideoService videoService;

    public InstructionalVideoController(InstructionalvideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<InstructionalVideo> createVideo(@RequestBody InstructionalVideo video) {
        return ResponseEntity.status(201).body(videoService.createVideo(video));
    }

    @GetMapping("/{title}")
    public ResponseEntity<InstructionalVideo> getVideoByTitle(@PathVariable String title) {
        InstructionalVideo video = videoService.getVideoByTitle(title);
        return video != null ? ResponseEntity.ok(video) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<InstructionalVideo>> getAllVideos(Pageable pageable) {
        return ResponseEntity.ok(videoService.getAllVideos(pageable));
    }

    @PutMapping("/{title}")
    public ResponseEntity<InstructionalVideo> updateVideo(@PathVariable String title, @RequestBody InstructionalVideo video) {
        InstructionalVideo updatedVideo = videoService.updateVideo(title, video);
        return updatedVideo != null ? ResponseEntity.ok(updatedVideo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteVideo(@PathVariable String title) {
        videoService.deleteVideo(title);
        return ResponseEntity.noContent().build();
    }
}
