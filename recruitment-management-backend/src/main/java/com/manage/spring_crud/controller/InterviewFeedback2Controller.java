package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.InterviewFeedback2;
import com.manage.spring_crud.services.InterviewFeedback2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback2")

public class InterviewFeedback2Controller {
    @Autowired
    private InterviewFeedback2Service interviewFeedback2Service;

    //Add new Level2 Feedback
    @PostMapping("/addInterviewFeedback2")
    public InterviewFeedback2 addInterviewFeedback2(@RequestBody InterviewFeedback2 interviewFeedback2) {
        System.out.println("Add called");
        return interviewFeedback2Service.addInterviewFeedback2(interviewFeedback2);
    }

    // Add more than 1 Level2 Feedback
    @PostMapping("/addInterviewFeedbacks2")
    public List<InterviewFeedback2> addAllInterviewFeedback2(@RequestBody List<InterviewFeedback2> interviewFeedback2s) {
        return interviewFeedback2Service.addAllInterviewFeedback2(interviewFeedback2s);
    }

    //Get Feedback2 details by Id
    @GetMapping("/getInterviewFeedback2ByID/{id}")
    public InterviewFeedback2 getInterviewFeedback2ById(@PathVariable int id) {
        return interviewFeedback2Service.getInterviewFeedback2ByID(id);
    }


    // Update Feedback 2 details
    @PutMapping("/updateInterviewFeedback2")
    public InterviewFeedback2 updateInterviewFeedback2(@RequestBody InterviewFeedback2 interviewFeedback2) {
        return interviewFeedback2Service.updateInterviewFeedback2(interviewFeedback2);
    }

    //GEt all interview feedback2 details
    @GetMapping("/getInterviewFeedbacks2")
    public List<InterviewFeedback2> getAllInterviewFeedback2() {
        return interviewFeedback2Service.getAllInterviewFeedback2();
    }
}
