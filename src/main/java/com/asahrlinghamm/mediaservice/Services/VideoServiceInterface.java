package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Pod;
import com.asahrlinghamm.mediaservice.Entities.Video;
import org.bson.types.ObjectId;

import java.util.List;

public interface VideoServiceInterface {

    Video addVideo(Video video);
    List<Video> getAllVideos();
    Video updateVideo(Video video, ObjectId id);

    void deleteVideo(ObjectId id);

}
