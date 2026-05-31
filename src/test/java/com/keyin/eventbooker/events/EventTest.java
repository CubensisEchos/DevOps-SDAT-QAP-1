package com.keyin.eventbooker.events;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventTest
{
    Event event = new Event();

    @BeforeEach
    void setUp()
    {
        event = new Event(1L, "Concert 1", "Temp Description", "August 12 - 7pm", "2500");
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
        Assertions.assertEquals("Temp Description", event.getEventDescription());
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
