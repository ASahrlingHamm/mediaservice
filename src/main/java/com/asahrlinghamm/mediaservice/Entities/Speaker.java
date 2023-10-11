package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import jakarta.persistence.*;
import java.util.List;

@Document(collection = "speakers")
public class Speaker {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //@ManyToMany
    private List<Pod> pods;

    public Speaker() {
    }

    public Speaker(int id, String name, List<Pod> pods) {
        this.id = id;
        this.name = name;
        this.pods = pods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pod> getPods() {
        return pods;
    }

    public void setPods(List<Pod> pods) {
        this.pods = pods;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pods=" + pods +
                '}';
    }
}
