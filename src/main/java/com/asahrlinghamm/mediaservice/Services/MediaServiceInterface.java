package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Media;
import org.bson.types.ObjectId;

import java.util.List;

public interface MediaServiceInterface {

    Media addSong(Media song);
    List<Media> getAllSongs();
    Media updateSong(Media song, ObjectId id);

    void deleteSong(ObjectId id);

    Media addPod(Media pod);
    List<Media> getAllPods();
    Media updatePod(Media pod, ObjectId id);

    void deletePod(ObjectId id);

    Media addVideo(Media video);
    List<Media> getAllVideos();
    Media updateVideo(Media video, ObjectId id);

    void deleteVideo(ObjectId id);

    List<Media> getAllMedia();

}
