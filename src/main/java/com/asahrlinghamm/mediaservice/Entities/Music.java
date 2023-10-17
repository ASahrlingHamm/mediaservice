package com.asahrlinghamm.mediaservice.Entities;

/*import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;*/
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "media")
@TypeAlias("music")
public class Music extends Media {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    /*private ObjectId id;
    private String name;*/
    private String releaseDate;
    //private int albumId;

   // @ManyToMany
    @DBRef
    private List<Artist> artists;
    //@ManyToMany
    @DBRef
    private List<Genre> genres;

    //@ManyToMany
    @DBRef
    private List<Album> albums;

    public Music() {
    }

    public Music(ObjectId id, String name, String releaseDate, List<Artist> artists, List<Genre> genres, List<Album> albums) {
        this.id = id;
        this.title = name;
        this.releaseDate = releaseDate;
        this.artists = artists;
        this.genres = genres;
        this.albums = albums;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

/*    public void setGenres(List<String> genres) {
        this.genres = genres;
    }*/

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Music{" +
                "releaseDate='" + releaseDate + '\'' +
                ", artists=" + artists +
                ", genres=" + genres +
                ", albums=" + albums +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
