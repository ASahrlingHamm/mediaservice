package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Media;
import org.bson.types.ObjectId;

import java.util.List;

public interface MediaServiceInterface {

    Media addMedia(Media media);
    Media updateMedia(Media media, ObjectId id);

    void deleteMedia(ObjectId id);

    List<Media> getAllMedia();

/*    List<Media> getAllMediaByArtist(Media artists);
    List<Media> getAllMediaByGenre(Media genres);*/

}
