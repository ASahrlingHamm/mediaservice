package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
//import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Document(collection = "pods")
public class Pod {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String title;
    private String description;
    private Date releaseDate;
    //private int albumId;

   // @ManyToMany
    private List<Speaker>speakers;
   // @ManyToMany
    private List<Genre>genres;

    public Pod() {
    }

    public Pod(ObjectId id, String title, String description, Date releaseDate, List<Speaker> speakers, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.speakers = speakers;
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

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Pod{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", speakers=" + speakers +
                ", genres=" + genres +
                '}';
    }
}

