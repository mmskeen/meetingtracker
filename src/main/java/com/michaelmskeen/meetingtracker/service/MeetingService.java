package com.michaelmskeen.meetingtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaelmskeen.meetingtracker.model.Meeting;
import com.michaelmskeen.meetingtracker.repository.MeetingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    public Meeting findById(Long id) {
        return meetingRepository.findById(id)
                           .orElseThrow(() -> new EntityNotFoundException("Meeting not found with id: " + id));
   }

   public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public void deleteById(Long id) {
        meetingRepository.deleteById(id);
    }

}