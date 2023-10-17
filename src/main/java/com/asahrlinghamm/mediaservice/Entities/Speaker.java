package com.asahrlinghamm.mediaservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
//import jakarta.persistence.*;
import java.util.List;

@Document(collection = "creators")
@TypeAlias("speakers")
public class Speaker {
/*
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId id;
    private String name;
*/

    //@ManyToMany
    @DBRef
    private List<Pod> pods;

    public Speaker() {
    }

    public Speaker(List<Pod> pods) {
        this.pods = pods;
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
                "pods=" + pods +
                '}';
    }
}
