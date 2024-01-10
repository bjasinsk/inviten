package com.inviten.api.features.meetings;

import com.inviten.api.features.users.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
public class MeetingController {
    private final IMeetingRepository meetingRepository;

    public MeetingController(IMeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @GetMapping("meetings/{meetingId}")
    Meeting one(@PathVariable String meetingId) {
        return meetingRepository.one(meetingId);
    }

    @PostMapping("/meetings")
    Meeting createAndSave(@RequestBody Meeting meeting) {
        return meetingRepository.createAndSave(meeting);
    }

    @PutMapping("meetings/{meetingId}/users")
    public void addMember(@PathVariable String meetingId, @RequestBody Member member){
        meetingRepository.addMember(meetingId, member);
    }

    @DeleteMapping("meetings/{meetingId}/users/{phoneNumber}")
    public void deleteMember(@PathVariable String meetingId, @PathVariable String phoneNumber){

        meetingRepository.deleteMember(meetingId, phoneNumber);
    }

    @DeleteMapping("meetings/{meetingId}/users")
    public void leaveMeeting(@PathVariable String meetingId){
        meetingRepository.leaveMeeting(meetingId);
    }
}
