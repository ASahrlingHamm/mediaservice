package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

@Document(collection = "movies")
public class Video {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String title;
    private String director;
    private String description;
    private Date releaseDate;
    //private int albumId;

    //@ManyToMany
    @DBRef
    private List<Actor>actors;
   // @ManyToMany
    @DBRef
    private List<Genre>genres;

    public Video() {
    }

    public Video(ObjectId id, String title, String director, String description, Date releaseDate, List<Actor> actors, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.description = description;
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.genres = genres;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", actors=" + actors +
                ", genres=" + genres +
                '}';
    }
}
