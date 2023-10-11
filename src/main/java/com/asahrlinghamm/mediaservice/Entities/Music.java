package com.asahrlinghamm.mediaservice.Entities;

/*import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.ManyToMany;*/
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
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
    private List<Artist> artists;
    //@ManyToMany
    private List<Genre> genres;

    //@ManyToMany
    private List<Album> albums;

    public Music() {
    }

    public Music(ObjectId id, String name, String releaseDate, List<Artist> artists, List<Genre> genres, List<Album> albums) {
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

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
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
