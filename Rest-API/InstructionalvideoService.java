package com.prjgrp.artf.service;

import com.prjgrp.artf.model.InstructionalVideo;
import com.prjgrp.artf.repository.InstructionalvideoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstructionalvideoService {

    private final InstructionalvideoRepository videoRepository;

    public InstructionalvideoService(InstructionalvideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public InstructionalVideo createVideo(InstructionalVideo video) {
        return videoRepository.save(video);
    }

    public InstructionalVideo getVideoByTitle(String title) {
        return videoRepository.findByTitle(title);
    }

    public Page<InstructionalVideo> getAllVideos(Pageable pageable) {
        return videoRepository.findAllVideos(pageable);
    }

    public InstructionalVideo updateVideo(String title, InstructionalVideo updatedVideo) {
        InstructionalVideo existingVideo = videoRepository.findByTitle(title);
        if (existingVideo != null) {
            existingVideo.setUrl(updatedVideo.getUrl());
            existingVideo.setDescription(updatedVideo.getDescription());
            return videoRepository.save(existingVideo);
        }
        return null;
    }

    public void deleteVideo(String title) {
        InstructionalVideo existingVideo = videoRepository.findByTitle(title);
        if (existingVideo != null) {
            videoRepository.delete(existingVideo);
        }
    }
}
