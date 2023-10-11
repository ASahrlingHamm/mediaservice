package com.asahrlinghamm.mediaservice.Repositories;

import com.asahrlinghamm.mediaservice.Entities.Video;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video, ObjectId> {

}
