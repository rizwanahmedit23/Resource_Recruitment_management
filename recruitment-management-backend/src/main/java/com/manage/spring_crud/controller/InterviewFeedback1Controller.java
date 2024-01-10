package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.InterviewFeedback1;
import com.manage.spring_crud.services.InterviewFeedback1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback1")


public class InterviewFeedback1Controller {
    @Autowired
    private InterviewFeedback1Service interviewFeedback1Service;

    //Add new Level1 Feedback
    @PostMapping("/addInterviewFeedback1")
    public InterviewFeedback1 addInterviewFeedback1(@RequestBody InterviewFeedback1 interviewFeedback1) {
        System.out.println("Add called");
        return interviewFeedback1Service.addInterviewFeedback1(interviewFeedback1);
    }

    // Add more than 1 Level1 Feedback
    @PostMapping("/addInterviewFeedbacks1")
    public List<InterviewFeedback1> addAllInterviewFeedback1(@RequestBody List<InterviewFeedback1> interviewFeedback1s) {
        return interviewFeedback1Service.addAllInterviewFeedback1(interviewFeedback1s);
    }

    //Get Feedback1 details by Id
    @GetMapping("/getInterviewFeedback1ByID/{id}")
    public InterviewFeedback1 getInterviewFeedback1ById(@PathVariable int id) {
        return interviewFeedback1Service.getInterviewFeedback1ByID(id);
    }


    // Update Candidate
    @PutMapping("/updateInterviewFeedback1")
    public InterviewFeedback1 updateInterviewFeedback1(@RequestBody InterviewFeedback1 interviewFeedback1) {
        return interviewFeedback1Service.updateInterviewFeedback1(interviewFeedback1);
    }

    //Get all Interview Feedback
    @GetMapping("/getInterviewFeedbacks1")
    public List<InterviewFeedback1> getAllInterviewFeedback1() {
        return interviewFeedback1Service.getAllInterviewFeedback1();
    }
}
