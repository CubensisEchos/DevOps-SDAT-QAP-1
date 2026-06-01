package com.keyin.eventbooker;

import com.keyin.eventbooker.events.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class BookingSystemTest
{
    BookingSystem bookingSystem;

    @BeforeEach
    public void setUp()
    {
        bookingSystem = new BookingSystem();
    }

    @AfterEach
    public void tearDown()
    {
        bookingSystem = null;
    }

    @Test
    void testAddNewEvent()
    {
        bookingSystem.addNewEventToSystem("The Birchmen at Distortion", "Test Description", LocalDateTime.of(2026, 8, 10, 20, 0), 100);

        Assertions.assertEquals(1, bookingSystem.getEvents().size());
    }

    @Test
    void testSearchEventById()
    {
        bookingSystem.addNewEventToSystem("Deadgaard at The Rockhouse", "Test Description", LocalDateTime.of(2026, 8, 12, 20, 0), 100);

        Event event = bookingSystem.searchEventById(1L);

        Assertions.assertNotNull(event);
        Assertions.assertEquals("Deadgaard at The Rockhouse", event.getEventName());
        Assertions.assertEquals("Test Description", event.getEventDescription());
        Assertions.assertEquals(LocalDateTime.of(2026, 8, 12, 20, 0), event.getEventDateTime());
    }

    @Test
    void testRegisterAttendeeForEvent()
    {
        bookingSystem.addNewEventToSystem("Go Ninja! at CBTG's", "Test Description", LocalDateTime.of(2026, 7, 11, 20, 0), 100);

        bookingSystem.registerAttendeeForEvent(1L, "Alexi", "Laiho", "CoBdftr@email.com");

        Event event = bookingSystem.searchEventById(1L);

        Assertions.assertEquals(1, event.getAttendees().size());
    }

    @Test
    void testRemoveAttendeeFromEvent()
    {
        bookingSystem.addNewEventToSystem("The Birchmen at Distortion", "Test Description", LocalDateTime.of(2026, 6, 22, 20, 0), 100);

        bookingSystem.registerAttendeeForEvent(1L, "Alexi", "Laiho", "CoBdftr@email.com");

        Event event = bookingSystem.searchEventById(1L);
        Long attendeeId = event.getAttendees().get(0).getAttendeeId();

        bookingSystem.cancelAttendeeRegistrationForEvent(1L, attendeeId);

        Assertions.assertEquals(0, event.getAttendees().size());
    }

    @Test
    void testEventCapacityLimit()
    {
        bookingSystem.addNewEventToSystem("Anvil at The Rockhouse", "Description", LocalDateTime.of(2026, 6, 18, 20, 30), 1);

        bookingSystem.registerAttendeeForEvent(1L, "Alexi", "Laiho", "CoBdftr@email.com");
        bookingSystem.registerAttendeeForEvent(1L, "Ritchie", "Blackmore", "Rainbow@email.com");

        Event event = bookingSystem.searchEventById(1L);

        Assertions.assertEquals(1, event.getAttendees().size());
    }

    @Test
    void testViewAllEvents()
    {
        bookingSystem.addNewEventToSystem("Emblem at Element", "Test Description", LocalDateTime.of(2026, 10, 12, 20, 0), 100);
        bookingSystem.addNewEventToSystem("The Birchmen at Distortion", "Test Description", LocalDateTime.of(2026, 8, 11, 20, 0), 100);

        Assertions.assertEquals(2, bookingSystem.getEvents().size());
    }

    @Test
    void testDuplicationRegistration()
    {
        bookingSystem.addNewEventToSystem("Deadgaard at The Rockhouse", "Description", LocalDateTime.of(2026, 8, 12, 20, 0), 100);

        bookingSystem.registerAttendeeForEvent(1L, "Alexi", "Laiho", "CoBdftr@email.com");
        bookingSystem.registerAttendeeForEvent(1L, "Johan", "Hegg", "CoBdftr@email.com");

        Event event = bookingSystem.searchEventById(1L);

        Assertions.assertEquals(1, event.getAttendees().size());
    }
}
