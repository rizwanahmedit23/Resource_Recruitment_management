package com.manage.spring_crud.services;

import com.manage.spring_crud.model.InterviewFeedback1;
import com.manage.spring_crud.repository.InterviewFeedback1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewFeedback1Service {

    @Autowired
    private InterviewFeedback1Repository interviewFeedback1Repository;

    public InterviewFeedback1 addInterviewFeedback1(InterviewFeedback1 interviewFeedback1) {
        return interviewFeedback1Repository.save(interviewFeedback1);
    }

    public List<InterviewFeedback1> addAllInterviewFeedback1(List<InterviewFeedback1> interviewFeedback1s) {
        return interviewFeedback1Repository.saveAll(interviewFeedback1s);

    }

    public InterviewFeedback1 getInterviewFeedback1ByID(int id) {
        return interviewFeedback1Repository.findById(id).orElse(null);
    }

    public InterviewFeedback1 updateInterviewFeedback1(InterviewFeedback1 interviewFeedback1) {
        InterviewFeedback1 exitingFeedback1 = interviewFeedback1Repository.findById(interviewFeedback1.getFeedback1id()).orElse(null);

        if(exitingFeedback1 == null) {
            return interviewFeedback1Repository.save(interviewFeedback1);
        } else {
            interviewFeedback1Repository.deleteById(exitingFeedback1.getFeedback1id());
            interviewFeedback1Repository.save(interviewFeedback1);
        }
        return interviewFeedback1;
    }

    public List<InterviewFeedback1> getAllInterviewFeedback1() {
        return interviewFeedback1Repository.findAll();

    }
}
