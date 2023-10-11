package com.asahrlinghamm.mediaservice.Controllers;

import com.asahrlinghamm.mediaservice.Entities.Music;
import com.asahrlinghamm.mediaservice.Entities.Pod;
import com.asahrlinghamm.mediaservice.Services.MusicService;
import com.asahrlinghamm.mediaservice.Services.PodService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pods")
public class PodController {

    @Autowired
    private PodService podService;

    @GetMapping("/")
    public List<Pod> getAllPods() {
        return podService.getAllPods();}


    @PostMapping("/")
    public ResponseEntity<Pod> addPod (@RequestBody Pod pod){
        return new ResponseEntity<Pod>(podService.addPod(pod), HttpStatus.OK);}


    @PutMapping("/{id}")
    public ResponseEntity<Pod> updatePod (@PathVariable("id") ObjectId id, @RequestBody Pod pod){
        return ResponseEntity.ok(podService.updatePod(pod, id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePod ( @PathVariable("id") ObjectId id){
        podService.deletePod(id);
        return new ResponseEntity<String>("Pod deleted!", HttpStatus.OK);
    }
}
