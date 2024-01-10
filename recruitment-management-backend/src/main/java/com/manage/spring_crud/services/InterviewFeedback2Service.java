package com.manage.spring_crud.services;

import com.manage.spring_crud.model.InterviewFeedback2;
import com.manage.spring_crud.repository.InterviewFeedback2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewFeedback2Service {

    @Autowired
    private InterviewFeedback2Repository interviewFeedback2Repository;

    public InterviewFeedback2 addInterviewFeedback2(InterviewFeedback2 interviewFeedback2) {
        return interviewFeedback2Repository.save(interviewFeedback2);
    }

    public List<InterviewFeedback2> addAllInterviewFeedback2(List<InterviewFeedback2> interviewFeedback2s) {
        return interviewFeedback2Repository.saveAll(interviewFeedback2s);

    }

    public InterviewFeedback2 getInterviewFeedback2ByID(int id) {
        return interviewFeedback2Repository.findById(id).orElse(null);
    }

    public InterviewFeedback2 updateInterviewFeedback2(InterviewFeedback2 interviewFeedback2) {
        InterviewFeedback2 exitingFeedback2 = interviewFeedback2Repository.findById(interviewFeedback2.getFeedback2id()).orElse(null);

        if(exitingFeedback2 == null) {
            return interviewFeedback2Repository.save(interviewFeedback2);
        } else {
            interviewFeedback2Repository.deleteById(exitingFeedback2.getFeedback2id());
            interviewFeedback2Repository.save(interviewFeedback2);
        }
        return interviewFeedback2;
    }

    public List<InterviewFeedback2> getAllInterviewFeedback2() {
        return interviewFeedback2Repository.findAll();
    }
}
