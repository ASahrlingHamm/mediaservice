package com.asahrlinghamm.mediaservice.Repositories;

import com.asahrlinghamm.mediaservice.Entities.Pod;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface PodRepository extends MongoRepository<Pod, ObjectId> {
}
