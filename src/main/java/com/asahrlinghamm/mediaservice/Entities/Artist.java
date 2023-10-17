package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
//import jakarta.persistence.*;
import java.util.List;

@Document(collection = "creators")
@TypeAlias("artists")
public class Artist {
/*    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String name;
    //private int albumId;*/

   // @ManyToMany
    @DBRef
    private List<Music> songs;

    public Artist() {
    }

    public Artist(List<Music> songs) {
        this.songs = songs;
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
                ", songs=" + songs +
                '}';
    }
}
