package com.asahrlinghamm.mediaservice.Repositories;

import com.asahrlinghamm.mediaservice.Entities.Music;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends MongoRepository<Music, ObjectId> {
}
