package com.keyin.eventbooker.events;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class EventTest
{
    Event event = new Event();

    @BeforeEach
    void setUp()
    {
        event = new Event(1L, "Concert 1", "Test Description", LocalDateTime.of(2026, 8, 12, 19, 0), 2500);
    }
    @AfterEach
    void tearDown()
    {
        event = null;
    }
    @Test
    void testEventCreation()
    {
        Assertions.assertEquals("Concert 1", event.getEventName());
        Assertions.assertEquals("Test Description", event.getEventDescription());
    }

    @Test
    void testEventSetters()
    {
        event.setEventName("Concert 3");
        event.setEventDescription("Temporary Description");

        Assertions.assertEquals("Concert 3", event.getEventName());
        Assertions.assertEquals("Temporary Description", event.getEventDescription());
    }
}
