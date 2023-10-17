package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Media;
import com.asahrlinghamm.mediaservice.Exceptions.ResourceNotFoundException;
import com.asahrlinghamm.mediaservice.Repositories.MediaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService implements MediaServiceInterface{

    @Autowired
    private MediaRepository mediaRepository;


    @Override
    public Media addSong(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public List<Media> getAllSongs() {
        return mediaRepository.findAll();
    }

    @Override
    public Media updateSong(Media song, ObjectId id) {
        Media s = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song", "Id", id));
        s.setTitle(song.getTitle());
        s.setMedia_type(song.getMedia_type());
        s.setUrl(song.getUrl());
        s.setRelease_date(song.getRelease_date());
        s.setGenres(song.getGenres());
        s.setArtists(song.getArtists());
        mediaRepository.save(s);
        return s;
    }

    @Override
    public void deleteSong(ObjectId id) {
        mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Music", "Id", id));
        mediaRepository.deleteById(id);
    }

    @Override
    public Media addPod(Media pod) {
        return mediaRepository.save(pod);
    }

    @Override
    public List<Media> getAllPods() {
        return mediaRepository.findAll();
    }

    @Override
    public Media updatePod(Media pod, ObjectId id) {
        Media p = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pod", "Id", id));
        p.setTitle(pod.getTitle());
        p.setMedia_type(pod.getMedia_type());
        p.setUrl(pod.getUrl());
        p.setRelease_date(pod.getRelease_date());
        p.setGenres(pod.getGenres());
        p.setArtists(pod.getArtists());
        mediaRepository.save(p);
        return p;
    }

    @Override
    public void deletePod(ObjectId id) {
        mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pod", "Id", id));
        mediaRepository.deleteById(id);
    }

    @Override
    public Media addVideo(Media video) {
        return mediaRepository.save(video);
    }

    @Override
    public List<Media> getAllVideos() {
        return mediaRepository.findAll();
    }

    @Override
    public Media updateVideo(Media video, ObjectId id) {
        Media v = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video", "Id", id));
        v.setTitle(video.getTitle());
        v.setMedia_type(video.getMedia_type());
        v.setUrl(video.getUrl());
        v.setRelease_date(video.getRelease_date());
        v.setGenres(video.getGenres());
        v.setArtists(video.getArtists());
        mediaRepository.save(v);
        return v;
    }

    @Override
    public void deleteVideo(ObjectId id) {
        mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video", "Id", id));
        mediaRepository.deleteById(id);
    }

    @Override
    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }


    /*List<Media> getAllMedia();
    Music updateSong(Music music, ObjectId id);

    void deleteSong(ObjectId id);*/
}
