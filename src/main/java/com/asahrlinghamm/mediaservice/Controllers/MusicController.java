package com.asahrlinghamm.mediaservice.Controllers;

import com.asahrlinghamm.mediaservice.Entities.Music;
import com.asahrlinghamm.mediaservice.Services.MusicService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RequestMapping("/song")
public class MusicController {

        @Autowired
        private MusicService musicService;

        @GetMapping("/songs")
     /*   public ResponseEntity getAllSongs() {
            return new ResponseEntity<>(musicService.getAllSongs(),HttpStatus.OK);
        }*/
        public List<Music> getAllSongs() {
            return musicService.getAllSongs();}


        @PostMapping("/addsong")
        public ResponseEntity<Music> addSong (@RequestBody Music music){
            return new ResponseEntity<Music>(musicService.addSong(music), HttpStatus.OK);}


        @PutMapping("/updatesong/{id}")
        public ResponseEntity<Music> updateSong (@PathVariable("id") ObjectId id, @RequestBody Music music){
            return ResponseEntity.ok(musicService.updateSong(music, id));}

        @DeleteMapping("deletesong/{id}")
        public ResponseEntity<String> deleteSong ( @PathVariable("id") ObjectId id){
            musicService.deleteSong(id);
            return new ResponseEntity<String>("Song deleted!", HttpStatus.OK);
        }
}
