package com.michaelmskeen.meetingtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michaelmskeen.meetingtracker.service.MeetingService;

@Controller
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping("/")
    public String showMeetings(Model model) {
        model.addAttribute("meetings", meetingService.findAll());
        return "index"; // Thymeleaf template name
    }

    // Additional handler methods
}