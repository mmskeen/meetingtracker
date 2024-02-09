package com.michaelmskeen.meetingtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.michaelmskeen.meetingtracker.model.Meeting;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}