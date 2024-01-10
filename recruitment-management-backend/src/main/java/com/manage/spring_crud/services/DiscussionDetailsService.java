package com.manage.spring_crud.services;

import com.manage.spring_crud.model.Candidate;
import com.manage.spring_crud.model.DiscussionDetails;
import com.manage.spring_crud.repository.CandidateRepository;
import com.manage.spring_crud.repository.DiscussionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionDetailsService {

    @Autowired
    private DiscussionDetailsRepository discussionDetailsRepository;
    public DiscussionDetails addDiscussionDetails(DiscussionDetails discussionDetails) {
        System.out.println("Add Discussion Details called");
        return discussionDetailsRepository.save(discussionDetails);

    }

    public List<DiscussionDetails> addAllDiscussionsDetails(List<DiscussionDetails> discussionDetailsList) {
        return discussionDetailsRepository.saveAll(discussionDetailsList);
    }

    public DiscussionDetails updateDiscussionDetails(DiscussionDetails discussionDetails) {
        DiscussionDetails exitingDiscussion = discussionDetailsRepository.findById(discussionDetails.getDiscussionId()).orElse(null);

        if(exitingDiscussion == null) {
            return discussionDetailsRepository.save(discussionDetails);
        } else {
            discussionDetailsRepository.deleteById(exitingDiscussion.getDiscussionId());
            discussionDetailsRepository.save(discussionDetails);
        }
        return discussionDetails;
    }

    public List<DiscussionDetails> getAllDiscussionsDetails() {
        return discussionDetailsRepository.findAll();
    }
}
