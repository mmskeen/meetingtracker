package com.michaelmskeen.meetingtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelmskeen.meetingtracker.model.Meeting;
import com.michaelmskeen.meetingtracker.repository.MeetingRepository;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    // Additional methods for CRUD operations
}