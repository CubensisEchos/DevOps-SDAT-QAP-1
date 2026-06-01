package com.keyin.eventbooker.events;

import com.keyin.eventbooker.Registration.Attendee;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an event in the system
 * Stores all event info,
 * including a list of attendees for each event
 */
public class Event
{
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private LocalDateTime eventDateTime;
    private int eventCapacity;

    private List<Attendee> attendees;

    public Event(Long eventId, String eventName, String eventDescription, LocalDateTime eventDateTime, int eventCapacity)
    {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDateTime = eventDateTime;
        this.eventCapacity = eventCapacity;

        this.attendees = new ArrayList<>();
    }

    public Event(String eventName, String eventDescription, LocalDateTime eventDateTime, int eventCapacity)
    {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDateTime = eventDateTime;
        this.eventCapacity = eventCapacity;

        this.attendees = new ArrayList<>();
    }

    public Event()
    {
        this.attendees = new ArrayList<>();
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public int getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(int eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    public List<Attendee> getAttendees()
    {
        return attendees;
    }

    public void addAttendee(Attendee attendee)
    {
        attendees.add(attendee);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("eventId=").append(eventId);
        sb.append(", eventName='").append(eventName).append('\'');
        sb.append(", eventDescription='").append(eventDescription).append('\'');
        sb.append(", eventDateTime='").append(eventDateTime).append('\'');
        sb.append(", eventCapacity=").append(eventCapacity);
        sb.append(", attendees=").append(attendees);
        sb.append('}');
        return sb.toString();
    }
}
