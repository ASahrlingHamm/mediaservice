package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import jakarta.persistence.*;
import java.util.List;

@Document(collection = "actors")
public class Actor {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

   // @ManyToMany
    private List<Video>videos;

    public Actor() {
    }

    public Actor(int id, String name, List<Video> videos) {
        this.id = id;
        this.name = name;
        this.videos = videos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", videos=" + videos +
                '}';
    }
}
