package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Music;
import org.bson.types.ObjectId;

import java.util.List;

public interface MusicServiceInterface {

    Music addSong(Music music);
    List<Music> getAllSongs();
    Music updateSong(Music music, ObjectId id);

    void deleteSong(ObjectId id);


}
