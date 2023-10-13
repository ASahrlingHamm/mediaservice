package com.asahrlinghamm.mediaservice.Entities;

/*import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;*/
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "music")
public class Music {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String name;
    private String releaseDate;
    //private int albumId;

   // @ManyToMany
    private List<String> artists;
    //@ManyToMany
    private List<String> genres;

    //@ManyToMany
    private List<String> albums;

    public Music() {
    }

    public Music(ObjectId id, String name, String releaseDate, List<String> artists, List genres, List<String> albums) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public List getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

/*    public void setGenres(List<String> genres) {
        this.genres = genres;
    }*/

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", artists=" + artists +
                ", genres=" + genres +
                ", albums=" + albums +
                '}';
    }
}
