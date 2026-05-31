package com.keyin.eventbooker.events;

public class Event
{
    //what is needed?
    // event name, event date & time, event capacity, event id
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private String eventDateTime;
    private String eventCapacity;

    public Event(Long eventId, String eventName, String eventDescription, String eventDateTime, String eventCapacity)
    {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDateTime = eventDateTime;
        this.eventCapacity = eventCapacity;
    }

    public Event(String eventName, String eventDescription, String eventDateTime, String eventCapacity) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDateTime = eventDateTime;
        this.eventCapacity = eventCapacity;
    }

    public Event()
    {

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

    public String getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(String eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("eventId=").append(eventId);
        sb.append(", eventName='").append(eventName).append('\'');
        sb.append(", eventDescription='").append(eventDescription).append('\'');
        sb.append(", eventDateTime='").append(eventDateTime).append('\'');
        sb.append(", eventCapacity='").append(eventCapacity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
