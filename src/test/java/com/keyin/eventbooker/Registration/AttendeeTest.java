package com.keyin.eventbooker.Registration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttendeeTest
{
    Attendee attendee;

    @BeforeEach
    void setUp()
    {
        attendee = new Attendee(1L, "Stephon", "Castle", "spurs2026@email.com");
    }

    @AfterEach
    void tearDown()
    {
        attendee = null;
    }

    @Test
    void TestAttendeeCreation()
    {
        Assertions.assertEquals(1L, attendee.getAttendeeId());
        Assertions.assertEquals("Stephon", attendee.getFirstName());
        Assertions.assertEquals("Castle", attendee.getLastName());
        Assertions.assertEquals("spurs2026@email.com", attendee.getEmail());
    }

    @Test
    void TestAttendeeSetters()
    {
        attendee.setFirstName("Victor");
        attendee.setLastName("Wembanyama");

        Assertions.assertEquals("Victor", attendee.getFirstName());
        Assertions.assertEquals("Wembanyama", attendee.getLastName());
    }
}
