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
        event = new Event(1L, "Deadgaard at The Rockhouse",
                "Join us on August 10th, for a night of local metal at the Rockhouse. No outside beverages/food allowed. Doors open at 8:00pm, music starts at 9:00pm.",
                LocalDateTime.of(2026, 8, 12, 19, 0), 100);
    }
    @AfterEach
    void tearDown()
    {
        event = null;
    }
    @Test
    void testEventCreation()
    {
        Assertions.assertEquals(1L, event.getEventId());
        Assertions.assertEquals("Deadgaard at The Rockhouse", event.getEventName());
        Assertions.assertEquals("Join us on August 10th, for a night of local metal at the Rockhouse. No outside beverages/food allowed. Doors open at 8:00pm, music starts at 9:00pm.", event.getEventDescription());
        Assertions.assertEquals(LocalDateTime.of(2026, 8, 12, 19, 0), event.getEventDateTime());
        Assertions.assertEquals(100, event.getEventCapacity());
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
