package com.keyin.eventbooker;

import com.keyin.eventbooker.events.Event;

public class UpcomingEvents
{
    public static void main(String[] args)
    {
        Event event1 = new Event( 1L, "Concert 1", "Temp Description", "august 12th - 7pm", "2500");
        Event event2 = new Event(2L, "Concert 2", "Temp Description", "august 13th - 7pm", "2500");
        System.out.println(event1);
        System.out.println(event2);
    }
}
