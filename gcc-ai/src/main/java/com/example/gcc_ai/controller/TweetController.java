package com.example.gcc_ai.controller;

import com.example.gcc_ai.Repository.TweetRepository;
import com.example.gcc_ai.dto.ComplaintDTO;
import com.example.gcc_ai.model.Tweet;
import com.example.gcc_ai.service.TweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TweetController {

    private final TweetService tweetService;
    private final TweetRepository complaintRepository;

    public TweetController(TweetService tweetService, TweetRepository complaintRepository) {
        this.tweetService = tweetService;
        this.complaintRepository = complaintRepository;
    }

    @GetMapping("/alltweets")
    public List<ComplaintDTO> getComplaints() {
        List<ComplaintDTO> complaints = complaintRepository.fetchAllComplaints();
        System.out.println("Fetched " + complaints.size() + " complaints.");
        return complaints;
    }

    @GetMapping("/complaints/{deptType}")
    public List<ComplaintDTO> getComplaintsByDept(@PathVariable String deptType) {
        return complaintRepository.fetchComplaintsByDeptType(deptType);
    }

}

