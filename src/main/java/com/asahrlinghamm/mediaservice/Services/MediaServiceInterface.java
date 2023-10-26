package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Media;
import org.bson.types.ObjectId;

import java.util.List;

public interface MediaServiceInterface {

    Media addMedia(Media media);
    Media updateMedia(Media media, ObjectId id);

    void deleteMedia(ObjectId id);

    List<Media> getAllMedia();

    List<Media> getMediaByArtist(String artist);

    List<Media> getMediaByType(String mediaType);

    List<Media> getMediaByGenre(String genres);

    Media getMediaById(ObjectId mediaId);

    //List<Media> getMediaByArtists(List<String> artists);

    //List<Media> getMediaByGenre(String genre);
    //List<Media> getMediaByGenres(List<String> genres);

   // List<Media> getMediaByMediaType(String mediaType);




}
