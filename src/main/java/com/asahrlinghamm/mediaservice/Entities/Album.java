package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Document(collection = "albums")
public class Album {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Date releaseDate;

    //@ManyToMany
    private List<Artist>artists;
    //@ManyToMany
    private List<Music> songs;

    public Album() {
    }

    public Album(int id, String title, Date releaseDate, List<Artist> artists, List<Music> songs) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.artists = artists;
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
