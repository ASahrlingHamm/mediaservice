package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Music;
import com.asahrlinghamm.mediaservice.Exceptions.ResourceNotFoundException;
import com.asahrlinghamm.mediaservice.Repositories.MusicRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements MusicServiceInterface {

    @Autowired
    private MusicRepository musicRepository;


    @Override
    public Music addSong(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public List<Music> getAllSongs() {
        return musicRepository.findAll();
    }

    @Override
    public Music updateSong(Music music, ObjectId id) {
        Music m = musicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Music", "Id", id));
        m.setTitle(music.getTitle());
        m.setReleaseDate(music.getReleaseDate());
        m.setArtists(music.getArtists());
        m.setGenres(music.getGenres());
        m.setAlbums(music.getAlbums());
        musicRepository.save(m);
        return m;
    }

    @Override
    public void deleteSong(ObjectId id) {
        musicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Music", "Id", id));
        musicRepository.deleteById(id);
    }
}
