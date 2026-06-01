package com.keyin.eventbooker;

import com.keyin.eventbooker.Registration.Attendee;
import com.keyin.eventbooker.events.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing the event booking system
 *
 * Handles creation of events, viewing all events, finding events and attendees by ID,
 * attendee registrations, duplicated registration prevention, and capacity limits.
 */
public class BookingSystem
{
    private List<Event> events = new ArrayList<>();
    private Long nextEventId = 1L;
    private Long nextAttendeeId = 1L;

    /**
     * Adds a new event to the system with an automatically generated ID
     *
     * @param eventName name of the event
     * @param eventDescription description of the event
     * @param eventDateTime date and time of the event
     * @param eventCapacity capacity of the event
     */
    public void addNewEventToSystem(String eventName, String eventDescription, LocalDateTime eventDateTime, int eventCapacity)
    {
        Event event = new Event(nextEventId, eventName, eventDescription, eventDateTime, eventCapacity);

        events.add(event);
        nextEventId++;
    }

    /**
     * Searches for an event by ID
     *
     * @param eventId unique Identifier of the event
     * @return the matching event, if it exists
     */
    public Event searchEventById(Long eventId)
    {
        for (Event event : events)
        {
            if (event.getEventId().equals(eventId))
            {
                return event;
            }
        }
        return null;
    }

    /**
     * Registers an attendee for selected event
     * Prevents duplicates and checks event capacity
     *
     * @param eventId ID of the chosen event
     * @param firstName attendee's first name
     * @param lastName attendee's last name
     * @param email attendee's email - used for duplication check
     */
    public void registerAttendeeForEvent(Long eventId, String firstName, String lastName, String email)
    {
        Event event = searchEventById(eventId);

        if (event == null)
        {
            System.out.println("Event " + eventId + " does not exist, please try again");
            return;
        }

        if (event.getAttendees().size() >= event.getEventCapacity())
            {
            System.out.println("This event is full, registration unavailable");
            return;
            }

        for (Attendee existing : event.getAttendees())
        {
            if (existing.getEmail().equalsIgnoreCase(email))
            {
                System.out.println("This attendee is already registered for this event");
                return;
            }
        }

        Attendee attendee = new Attendee(nextAttendeeId, firstName, lastName, email);

        nextAttendeeId++;

        event.addAttendee(attendee);

        System.out.println("Attendee has successfully been registered for the event");
    }

    /**
     * Cancels an attendee's registration for selected event
     *
     * @param eventId ID of the chosen event
     * @param attendeeId ID of the attendee to remove
     */
    public void cancelAttendeeRegistrationForEvent(Long eventId, Long attendeeId)
    {
        Event event = searchEventById(eventId);

        if (event == null)
        {
            System.out.println("Event " + eventId + " does not exist, please try again");
            return;
        }

        Attendee toRemove = null;

        for (Attendee attendee : event.getAttendees())
        {
            if (attendee.getAttendeeId().equals(attendeeId))
            {
                toRemove = attendee;
                break;
            }
        }

        if (toRemove == null)
        {
            System.out.println("Attendee not found, please try another ID");
            return;
        }

        event.getAttendees().remove(toRemove);

        System.out.println("Attendee has been successfully removed from the event registration.");
    }

    /**
     * Displays all events in the system
     * Shows event ID, name, and date/time
     */
    public void viewAllEvents()
    {
        if (events.isEmpty())
        {
            System.out.println("There are no events in the system");
            return;
        }

        for (Event event : events)
        {
            System.out.println("==========================");
            System.out.println("Event ID: " + event.getEventId());
            System.out.println("Event Name: " + event.getEventName());
            System.out.println("Event Date & Time: " + event.getEventDateTime());
        }
        System.out.println("==========================");
    }

    /**
     * Returns internal list of events
     * used for testing purposes
     *
     * @return list of events
     */
    public List<Event> getEvents()
    {
        return events;
    }
}
