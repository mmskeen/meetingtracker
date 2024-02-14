package com.michaelmskeen.meetingtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.michaelmskeen.meetingtracker.model.Meeting;
import com.michaelmskeen.meetingtracker.repository.MeetingRepository;

import jakarta.annotation.PostConstruct;


@Component
public class SampleDataInitializer {

    private final MeetingRepository meetingRepository;

    @Autowired
    public SampleDataInitializer(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @PostConstruct
    public void init() {
        // Create and save some sample meetings
        Meeting meeting1 = new Meeting();
        meeting1.setName("Sample Meeting 1");
        meeting1.setDescription("This is a sample meeting 1");
        // Set other properties as needed
        meetingRepository.save(meeting1);

        Meeting meeting2 = new Meeting();
        meeting2.setName("Sample Meeting 2");
        meeting2.setDescription("This is a sample meeting 2");
        // Set other properties as needed
        meetingRepository.save(meeting2);

        // Add more sample meetings as necessary
    // No code generation required for this task.
    }
}
