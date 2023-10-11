package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Music;
import com.asahrlinghamm.mediaservice.Entities.Pod;
import org.bson.types.ObjectId;

import java.util.List;

public interface PodServiceInterface {

    Pod addPod(Pod pod);
    List<Pod> getAllPods();
    Pod updatePod(Pod pod, ObjectId id);

    void deletePod(ObjectId id);

}
