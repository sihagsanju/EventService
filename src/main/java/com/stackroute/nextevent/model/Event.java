package com.stackroute.nextevent.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;


@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @NotNull
    private String name;

    @NotNull
    private String description;

    private DateFormat created;

    //@NotNull
    private DateFormat start;

    //@NotNull
    private  DateFormat end;

    @NotNull
    private String imageUrl;

    public Long getId() {
        return eventId;
    }

    public void setId(Long id) {
        this.eventId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateFormat getCreated() {
        return created;
    }

    public void setCreated(DateFormat created) {
        this.created = created;
    }

    public DateFormat getStart() {
        return start;
    }

    public void setStart(DateFormat start) {
        this.start = start;
    }

    public DateFormat getEnd() {
        return end;
    }

    public void setEnd(DateFormat end) {
        this.end = end;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + eventId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", start=" + start +
                ", end=" + end +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
