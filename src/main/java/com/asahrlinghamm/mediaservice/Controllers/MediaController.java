package com.asahrlinghamm.mediaservice.Controllers;

import com.asahrlinghamm.mediaservice.Entities.Media;
import com.asahrlinghamm.mediaservice.Services.MediaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
public class MediaController {

    @Autowired
    private MediaService mediaService;


    @GetMapping
    @RequestMapping("/everything")
    public ResponseEntity getEverythingAllAtOnce() {
        return new ResponseEntity(mediaService.getAllMedia(), HttpStatus.OK);
    }

    @GetMapping("/getmediabytype/{mediatype}")
    public ResponseEntity<List<Media>> getMediaByType(@PathVariable String mediatype){
        return ResponseEntity.ok(mediaService.getAllMediaByMediaType(mediatype));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Media>> getMediaByGenre(@PathVariable String genre){
        return ResponseEntity.ok(mediaService.getMediaByGenre(genre));
    }

    @GetMapping("/genres/{genres}")
    public ResponseEntity<List<Media>> getMediaByGenres(@PathVariable String  genres){
        return ResponseEntity.ok(mediaService.getMediaByGenres(deconstruct(genres)));
    }

    @GetMapping("/artist/{artist}")
    public ResponseEntity<List<Media>> getMediaForArtist(@PathVariable String artist){
        return ResponseEntity.ok((mediaService.getMediaByArtist(artist)));
    }

    @GetMapping("/artists/{artists}")
    public ResponseEntity<List<Media>> getMediaByArtists(@PathVariable String artists){
        return ResponseEntity.ok((mediaService.getMediaByArtists(deconstruct(artists))));
    }


/*
    @GetMapping
    @RequestMapping("/allmediabyartist/{artists}")
    public ResponseEntity getAllMediaByArtist(@PathVariable String[] artists) {
        return new ResponseEntity(mediaService.getAllMediaByArtist(),HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/allmediabyartist/{genres}")
    public ResponseEntity getAllMediaByGenre(@PathVariable String[] genres) {
        return new ResponseEntity(mediaService.getAllMediaByGenre(),HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/allmediabyartist/{artists}")
    public List<Media>getAllMediaByArtist(@PathVariable String artists) {
            return mediaService.getAllMediaByArtist();
    }

    @GetMapping
    @RequestMapping("/allmediabygenre/{genres}")
    public List<Media>getAllMediaByGenre(@PathVariable String genres) {
        return mediaService.getAllMediaByArtist();
    }
    */


    //
    public List<String> deconstruct(String pathVariable){
        String[] list ;
        list = pathVariable.split(",");
        return Arrays.stream(list).toList();
    }



}
