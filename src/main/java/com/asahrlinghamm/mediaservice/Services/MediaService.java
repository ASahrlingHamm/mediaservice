package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Media;
import com.asahrlinghamm.mediaservice.Entities.ObjectIdDto;
import com.asahrlinghamm.mediaservice.Exceptions.ResourceNotFoundException;
import com.asahrlinghamm.mediaservice.Repositories.MediaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return mediaRepository.findMediaByMediaTypeContains("song");
    }

    @Override
    public Media updateSong(Media song, ObjectId id) {
        Media s = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song", "Id", id));
        s.setTitle(song.getTitle());
        s.setMediaType(song.getMediaType());
        s.setUrl(song.getUrl());
        s.setReleaseDate(song.getReleaseDate());
        s.setGenres(song.getGenres());
        s.setArtists(song.getArtists());
        mediaRepository.save(s);
        return s;
    }

    public List<Media> getMediaByGenre(String genre){
        return mediaRepository.findMediaByGenresContainsIgnoreCase(genre);
    }

    public List<Media> getMediaByGenres(List<String> genres){
        return mediaRepository.findMediaByGenresContainsIgnoreCase(genres);
    }

    public List<Media> getMediaByArtist(String artist){
        return mediaRepository.findMediaByArtistsContainsIgnoreCase(artist);
    }

    public List<Media> getMediaByArtists(List<String> artists){
        return mediaRepository.findMediaByArtistsContainsIgnoreCase(artists);
    }

    public List<Media> getListOfMediaByIds(List<ObjectIdDto> request){
        List<ObjectId> test = new ArrayList<>();
        for(ObjectIdDto dto:request){
            test.add(dto.getObjectId());
        }
        return (List<Media>) mediaRepository.findAllById(test);
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
        return mediaRepository.findMediaByMediaTypeContains("podcast");
    }

    @Override
    public Media updatePod(Media pod, ObjectId id) {
        Media p = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pod", "Id", id));
        p.setTitle(pod.getTitle());
        p.setMediaType(pod.getMediaType());
        p.setUrl(pod.getUrl());
        p.setReleaseDate(pod.getReleaseDate());
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
        return mediaRepository.findMediaByMediaTypeContains("movie");
    }

    @Override
    public Media updateVideo(Media video, ObjectId id) {
        Media v = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Video", "Id", id));
        v.setTitle(video.getTitle());
        v.setMediaType(video.getMediaType());
        v.setUrl(video.getUrl());
        v.setReleaseDate(video.getReleaseDate());
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


}
