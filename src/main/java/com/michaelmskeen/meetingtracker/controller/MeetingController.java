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
import com.michaelmskeen.meetingtracker.model.Meeting;

@Controller
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping("/")
    public String showMeetings(Model model) {
        model.addAttribute("meetings", meetingService.findAll());
        return "index"; // Thymeleaf template name
    }

    @PostMapping("/")
    public String createMeeting(@ModelAttribute Meeting meeting) {
        meetingService.save(meeting);
        return "redirect:/"; 
    }

    @DeleteMapping("/meeting/{id}/delete")
    public String deleteMeeting(@PathVariable Long id) {
        meetingService.deleteById(id);
        return "redirect:/";
    }

}