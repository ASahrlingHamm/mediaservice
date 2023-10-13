package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
//import jakarta.persistence.*;
import java.util.List;

@Document(collection = "genres")
public class Genre {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String name;

   // @ManyToMany
    private List<Music>music;
    //@ManyToMany
    private List<Pod>pods;
   // @ManyToMany
    private List<Video>videos;

    public Genre() {
    }

    public Genre(ObjectId id, String name, List<Music> music, List<Pod> pods, List<Video> videos) {
        this.id = id;
        this.name = name;
        this.music = music;
        this.pods = pods;
        this.videos = videos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    public List<Pod> getPods() {
        return pods;
    }

    public void setPods(List<Pod> pods) {
        this.pods = pods;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", music=" + music +
                ", pods=" + pods +
                ", videos=" + videos +
                '}';
    }
}
