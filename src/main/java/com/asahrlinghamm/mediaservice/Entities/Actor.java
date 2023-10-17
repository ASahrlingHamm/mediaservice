package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
//import jakarta.persistence.*;
import java.util.List;

@Document(collection = "creators")
@TypeAlias("actors")
public class Actor {
 /*   @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String name;*/

   // @ManyToMany
    @DBRef
    private List<Video>videos;

    public Actor() {
    }

    public Actor(List<Video> videos) {
        this.videos = videos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Actor{" +
                ", videos=" + videos +
                '}';
    }
}
