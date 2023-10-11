package com.asahrlinghamm.mediaservice.Services;

import com.asahrlinghamm.mediaservice.Entities.Pod;
import com.asahrlinghamm.mediaservice.Exceptions.ResourceNotFoundException;
import com.asahrlinghamm.mediaservice.Repositories.PodRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodService implements PodServiceInterface{

    @Autowired
    private PodRepository podRepository;

    @Override
    public Pod addPod(Pod pod) {
        return podRepository.save(pod);
    }

    @Override
    public List<Pod> getAllPods() {
        return podRepository.findAll();
    }

    @Override
    public Pod updatePod(Pod pod, ObjectId id) {
        Pod p = podRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pod", "Id", id));
        p.setTitle(pod.getTitle());
        p.setDescription(pod.getDescription());
        p.setReleaseDate(pod.getReleaseDate());
        p.setSpeakers(pod.getSpeakers());
        p.setGenres(pod.getGenres());
        podRepository.save(p);
        return p;
    }

    @Override
    public void deletePod(ObjectId id) {
        podRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pod", "Id", id));
        podRepository.deleteById(id);
    }
}
