package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Document(collection = "artists")
public class Artist {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //private int albumId;

   // @ManyToMany
    private List<Music> songs;

    public Artist() {
    }

    public Artist(int id, String name, List<Music> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
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

    public List<Music> getSongs() {
        return songs;
    }

    public void setSongs(List<Music> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songs=" + songs +
                '}';
    }
}
