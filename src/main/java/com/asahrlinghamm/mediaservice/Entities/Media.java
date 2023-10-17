package com.asahrlinghamm.mediaservice.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "media")
public class Media {
    private ObjectId id;
    private String title;
    private String mediaType;
    private String url;
    private String releaseDate;
    private String genres;
    @DBRef
    private List<String> artists;

    public Media() {
    }

    public Media(ObjectId id, String title, String mediaType, String url, String releaseDate, String genres, List<String> artists) {
        this.id = id;
        this.title = title;
        this.mediaType = mediaType;
        this.url = url;
        this.releaseDate = releaseDate;
        this.genres = genres;
        this.artists = artists;
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

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", url='" + url + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genres='" + genres + '\'' +
                ", artists=" + artists +
                '}';
    }
}

