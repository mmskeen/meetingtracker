package com.michaelmskeen.meetingtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.michaelmskeen.meetingtracker.service.MeetingService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;

import com.michaelmskeen.meetingtracker.model.Meeting;

@Controller
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping("/")
    @Operation(summary = "Get all meetings")
    public String showMeetings(Model model) {
        model.addAttribute("meetings", meetingService.findAll());
        return "index"; // Thymeleaf template name
    }

    @PostMapping("/")
    public String createMeeting(@ModelAttribute Meeting meeting) {
        meetingService.save(meeting);
        return "redirect:/"; 
    }

    @GetMapping("/meeting/{id}")
    @Operation(summary = "Get a meeting by its ID")
    public String showMeeting(@PathVariable Long id, Model model) {
        try {
            Meeting meeting = meetingService.findById(id);
            model.addAttribute("meeting", meeting);
            return "meeting-details"; // Thymeleaf template name for meeting details
        } catch (EntityNotFoundException e) {
            return "meeting-not-found";
        }
    }

    @PostMapping("/meeting/{id}")
    public String updateMeeting(@PathVariable Long id, @ModelAttribute Meeting meeting) {
        try {
            Meeting existingMeeting = meetingService.findById(id);
            existingMeeting.setName(meeting.getName());
            existingMeeting.setDescription(meeting.getDescription());
            // Update other properties as needed
            meetingService.save(existingMeeting);
            return "redirect:/"; // Redirect to the homepage after updating the meeting
        } catch (EntityNotFoundException e) {
            return "meeting-not-found";
        }
    }

    @DeleteMapping("/meeting/{id}/delete")
    public String deleteMeeting(@PathVariable Long id) {
        meetingService.deleteById(id);
        return "redirect:/";
    }

}