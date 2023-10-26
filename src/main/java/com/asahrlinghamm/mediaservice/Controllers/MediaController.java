package com.asahrlinghamm.mediaservice.Controllers;

import com.asahrlinghamm.mediaservice.Entities.Media;
import com.asahrlinghamm.mediaservice.Entities.ObjectIdDto;
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

    @PostMapping("/media")
    public ResponseEntity<Media> addMedia (@RequestBody Media media){
        return new ResponseEntity<Media>(mediaService.addMedia(media), HttpStatus.OK);}


    @PutMapping("/media/{id}")
    public ResponseEntity<Media> updateMedia (@PathVariable("id") ObjectId id, @RequestBody Media media){
        return ResponseEntity.ok(mediaService.updateMedia(media, id));}

    @DeleteMapping("media/{id}")
    public ResponseEntity<String> deleteMedia ( @PathVariable("id") ObjectId id){
        mediaService.deleteMedia(id);
        return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
    }


    @GetMapping("/getmediabytype/{mediatype}")
    public ResponseEntity<List<Media>> getMediaByType(@PathVariable String mediatype){
        return ResponseEntity.ok(mediaService.getMediaByType(mediatype));
    }

    @GetMapping("/mediabyid/{mediaId}")
    public ResponseEntity<Media> getMediaById(@PathVariable ObjectId mediaId) {
        return ResponseEntity.ok(mediaService.getMediaById(mediaId));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Media>> getMediaByGenre(@PathVariable String genre){
        return ResponseEntity.ok(mediaService.getMediaByGenre(genre));
    }

    @GetMapping("/artist/{artist}")
    public ResponseEntity<List<Media>> getMediaForArtist(@PathVariable String artist){
        return ResponseEntity.ok((mediaService.getMediaByArtist(artist)));
    }

    @PostMapping("/media/list")
    public ResponseEntity<List<Media>> getListOfMedia(@RequestBody List<ObjectIdDto> request){
        return ResponseEntity.ok(mediaService.getListOfMediaByIds(request));
    }
    
    @GetMapping("/media/{mediaId}")
    public ResponseEntity<Media> getMediaById(@PathVariable ObjectId mediaId) {
    	return ResponseEntity.ok(mediaService.getMediaById(mediaId));
    }

    public List<String> deconstruct(String pathVariable){
        String[] list ;
        list = pathVariable.split(",");
        return Arrays.stream(list).toList();
    }




 /*   @GetMapping("/getmediabygenre/{genre}")
    public ResponseEntity<List<Media>> getMediaByGenre(@PathVariable String genre){
        return ResponseEntity.ok(mediaService.getMediaByGenre(genre));
    }*/

   /* @GetMapping("/getmediabymediatype/{mediatype}")
    public ResponseEntity<List<Media>> getMediaByMediaType(@PathVariable String mediatype){
        return ResponseEntity.ok(mediaService.getMediaByMediaType(mediatype));
    }*/

/*    @GetMapping("/genres/{genres}")
    public ResponseEntity<List<Media>> getMediaByGenres(@PathVariable String  genres){
        return ResponseEntity.ok(mediaService.getMediaByGenres(deconstruct(genres)));
    }*/

/*    @GetMapping("/artists/{artists}")
    public ResponseEntity<List<Media>> getMediaByArtists(@PathVariable String artists){
        return ResponseEntity.ok((mediaService.getMediaByArtists(deconstruct(artists))));
    }*/

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



}
