package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
//import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Document(collection = "albums")
public class Album {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String title;
    private Date releaseDate;

    //@ManyToMany
    @DBRef
    private List<Artist>artists;
    //@ManyToMany
    @DBRef
    private List<Music> songs;

    public Album() {
    }

    public Album(ObjectId id, String title, Date releaseDate, List<Artist> artists, List<Music> songs) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.artists = artists;
        this.songs = songs;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Music> getSongs() {
        return songs;
    }

    public void setSongs(List<Music> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", artists=" + artists +
                ", songs=" + songs +
                '}';
    }
}
