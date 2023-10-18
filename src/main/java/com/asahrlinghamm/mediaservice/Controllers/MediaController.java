package com.asahrlinghamm.mediaservice.Controllers;

import com.asahrlinghamm.mediaservice.Entities.Media;
import com.asahrlinghamm.mediaservice.Services.MediaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MediaController {

    @Autowired
    private MediaService mediaService;


    @GetMapping
    @RequestMapping("/everything")
    public ResponseEntity getEverythingAllAtOnce() {
        return new ResponseEntity(mediaService.getAllMedia(),HttpStatus.OK);
    }


    @GetMapping
    @RequestMapping("/songs")
  /*      public ResponseEntity getAllSongs() {
            return new ResponseEntity<>(mediaService.getAllSongs(),HttpStatus.OK);
        }*/
    public List<Media> getAllSongs() {
        return mediaService.getAllSongs();}


    @PostMapping("/addsong")
    public ResponseEntity<Media> addSong (@RequestBody Media song){
        return new ResponseEntity<Media>(mediaService.addSong(song), HttpStatus.OK);}


    @PutMapping("/updatesong/{id}")
    public ResponseEntity<Media> updateSong (@PathVariable("id") ObjectId id, @RequestBody Media song){
        return ResponseEntity.ok(mediaService.updateSong(song, id));}

    @DeleteMapping("deletesong/{id}")
    public ResponseEntity<String> deleteSong ( @PathVariable("id") ObjectId id){
        mediaService.deleteSong(id);
        return new ResponseEntity<String>("Song deleted!", HttpStatus.OK);
    }

    @GetMapping("/pods")
    public List<Media> getAllPods() {
        return mediaService.getAllPods();}


    @PostMapping("/addPod")
    public ResponseEntity<Media> addPod (@RequestBody Media pod){
        return new ResponseEntity<Media>(mediaService.addPod(pod), HttpStatus.OK);}


    @PutMapping("/updatepod/{id}")
    public ResponseEntity<Media> updatePod (@PathVariable("id") ObjectId id, @RequestBody Media pod){
        return ResponseEntity.ok(mediaService.updatePod(pod, id));}

    @DeleteMapping("/deletepod/{id}")
    public ResponseEntity<String> deletePod ( @PathVariable("id") ObjectId id){
        mediaService.deletePod(id);
        return new ResponseEntity<String>("Pod deleted!", HttpStatus.OK);
    }

    @GetMapping("/movies")
    public List<Media> getAllVideos() {
        return mediaService.getAllVideos();}


    @PostMapping("/addmovie")
    public ResponseEntity<Media> addVideo (@RequestBody Media video){
        return new ResponseEntity<Media>(mediaService.addVideo(video), HttpStatus.OK);}


    @PutMapping("/updatemovie/{id}")
    public ResponseEntity<Media> updateVideo (@PathVariable("id") ObjectId id, @RequestBody Media video){
        return ResponseEntity.ok(mediaService.updateVideo(video, id));}

    @DeleteMapping("/deletemovie/{id}")
    public ResponseEntity<String> deleteVideo ( @PathVariable("id") ObjectId id){
        mediaService.deleteVideo(id);
        return new ResponseEntity<String>("Movie deleted!", HttpStatus.OK);
    }
}
