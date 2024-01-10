package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.Candidate;
import com.manage.spring_crud.model.DiscussionDetails;
import com.manage.spring_crud.services.CandidateService;
import com.manage.spring_crud.services.DiscussionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discussiondetails")


public class DiscussionDetailsController {
    @Autowired
    private DiscussionDetailsService discussionDetailsService;

    //Add new Discussion
    @PostMapping("/addDiscussionDetails")
    public DiscussionDetails addDiscussionDetails(@RequestBody DiscussionDetails discussionDetails) {
        System.out.println("Discussion Details called");
        return discussionDetailsService.addDiscussionDetails(discussionDetails);
    }

    // Add more than 1 Discussion Details
    @PostMapping("/addDiscussionsDetails")
    public List<DiscussionDetails> addAllDiscussionsDetails(@RequestBody List<DiscussionDetails> discussionDetailsList) {
        return discussionDetailsService.addAllDiscussionsDetails(discussionDetailsList);
    }

    // Update Discussion Details
    @PutMapping("/updateDiscussionDetails")
    public DiscussionDetails updateDiscussionDetails(@RequestBody DiscussionDetails discussionDetails) {
        return discussionDetailsService.updateDiscussionDetails(discussionDetails);
    }

    // Get all Discussion Details
    @GetMapping("/getDiscussionsDetails")
    public List<DiscussionDetails> getAllDiscussionsDetails() {
        return discussionDetailsService.getAllDiscussionsDetails();

    }


}
