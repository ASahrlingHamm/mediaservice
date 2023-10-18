package com.asahrlinghamm.mediaservice.Repositories;

import com.asahrlinghamm.mediaservice.Entities.Media;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MediaRepository extends MongoRepository<Media, ObjectId> {
    List<Media>findMediaByMediaTypeContains(String mediaType);

}
