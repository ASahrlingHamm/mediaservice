package com.asahrlinghamm.mediaservice.Controllers;

import com.asahrlinghamm.mediaservice.Entities.Video;
import com.asahrlinghamm.mediaservice.Services.VideoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();}


    @PostMapping("/")
    public ResponseEntity<Video> addVideo (@RequestBody Video video){
        return new ResponseEntity<Video>(videoService.addVideo(video), HttpStatus.OK);}


    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo (@PathVariable("id") ObjectId id, @RequestBody Video video){
        return ResponseEntity.ok(videoService.updateVideo(video, id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo ( @PathVariable("id") ObjectId id){
        videoService.deleteVideo(id);
        return new ResponseEntity<String>("Movie deleted!", HttpStatus.OK);
    }
}
