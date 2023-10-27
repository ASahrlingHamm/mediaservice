package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Media;
import com.asahrlinghamm.mediaservice.Exceptions.ResourceNotFoundException;
import com.asahrlinghamm.mediaservice.Repositories.MediaRepository;
import com.asahrlinghamm.mediaservice.Entities.ObjectIdDto;
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
    public Media addMedia(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public Media updateMedia(Media media, ObjectId id) {
        Media m = mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Media", "Id", id));
        m.setTitle(media.getTitle());
        m.setMediaType(media.getMediaType());
        m.setUrl(media.getUrl());
        m.setReleaseDate(media.getReleaseDate());
        m.setGenres(media.getGenres());
        m.setArtists(media.getArtists());
        mediaRepository.save(m);
        return m;
    }

    @Override
    public void deleteMedia(ObjectId id) {
        mediaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Media", "Id", id));
        mediaRepository.deleteById(id);
    }

    @Override
    public Media getMediaById(ObjectId mediaId) {
        return mediaRepository.findById(mediaId).orElseThrow(() -> new ResourceNotFoundException("Media", "ID", mediaId));
    }

    @Override
    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public List<Media> getAllMediaByMediaType(String mediaType) {
        return mediaRepository.findMediaByMediaType(mediaType);
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

    public List<Media> getMediaByArtistsAndMediaType(String artist, String mediaType){
        return mediaRepository.findMediaByMediaTypeAndArtistsContains(mediaType,artist);
        //return mediaRepository.findMediaByMediaType(mediaType);
    }

    public List<Media> getListOfMediaByIds(List<ObjectIdDto> request){
        List<ObjectId> test = new ArrayList<>();
        for(ObjectIdDto dto:request){
            test.add(dto.getObjectId());
        }
        return (List<Media>) mediaRepository.findAllById(test);
    }


/*    @Override
    public List<Media> getAllMediaByArtist(Media artists) {

        return mediaRepository.findMediaByArtistsContaining();
    }

    @Override
    public List<Media> getAllMediaByGenre(Media genres) {

        return mediaRepository.findMediaByGenresContaining();
    }*/



}
