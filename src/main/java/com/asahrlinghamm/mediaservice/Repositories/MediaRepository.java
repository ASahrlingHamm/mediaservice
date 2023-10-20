package com.asahrlinghamm.mediaservice.Repositories;

import com.asahrlinghamm.mediaservice.Entities.Media;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MediaRepository extends MongoRepository<Media, ObjectId> {
    List<Media>findMediaByMediaTypeContains(String mediaType);

    List<Media> findMediaByGenresContainsIgnoreCase(String genre);

    List<Media> findMediaByArtistsContainsIgnoreCase(String artist);

    List<Media> findMediaByGenresContainsIgnoreCase(List<String> genres);

    List<Media> findMediaByArtistsContainsIgnoreCase(List<String> artists);






    //List<Media>findMediaByTitleContains(String title);
    //List<Media>findMediaByArtistsContains(String artist);
    //List<Media>findMediaByReleaseDateContains(String releaseDate);

}
