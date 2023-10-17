package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Video;
import com.asahrlinghamm.mediaservice.Exceptions.ResourceNotFoundException;
import com.asahrlinghamm.mediaservice.Repositories.VideoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements VideoServiceInterface{

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public Video updateVideo(Video video, ObjectId id) {
        Video v = videoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video", "Id", id));
        v.setTitle(video.getTitle());
        v.setDirector(video.getDirector());
        v.setDescription(video.getDescription());
        v.setReleaseDate(video.getReleaseDate());
        v.setActors(video.getActors());
        v.setGenres(video.getGenres());
        videoRepository.save(v);
        return v;
    }

    @Override
    public void deleteVideo(ObjectId id) {
        videoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video", "Id", id));
        videoRepository.deleteById(id);
    }
}
