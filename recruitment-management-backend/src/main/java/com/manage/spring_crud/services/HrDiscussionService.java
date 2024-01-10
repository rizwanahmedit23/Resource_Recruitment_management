package com.manage.spring_crud.services;

import com.manage.spring_crud.model.HrDiscussion;
import com.manage.spring_crud.repository.HrDiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrDiscussionService {

    @Autowired
    private HrDiscussionRepository hrDiscussionRepository;

    public HrDiscussion addHrDiscussion(HrDiscussion hrDiscussion) {
        return hrDiscussionRepository.save(hrDiscussion);
    }

    public List<HrDiscussion> addAllHrDiscussion(List<HrDiscussion> hrDiscussions) {
        return hrDiscussionRepository.saveAll(hrDiscussions);
    }

    public HrDiscussion getHrDiscussionByID(int id) {
        return hrDiscussionRepository.findById(id).orElse(null);

    }

    public HrDiscussion updateHrDiscussion(HrDiscussion hrDiscussion) {
        HrDiscussion exitingHrFeedback = hrDiscussionRepository.findById(hrDiscussion.getHrDiscussionId()).orElse(null);

        if(exitingHrFeedback == null) {
            return hrDiscussionRepository.save(hrDiscussion);
        } else {
            hrDiscussionRepository.deleteById(exitingHrFeedback.getHrDiscussionId());
            hrDiscussionRepository.save(hrDiscussion);
        }
        return hrDiscussion;
    }

    public List<HrDiscussion> getAllHrDiscussions() {
        return hrDiscussionRepository.findAll();

    }
}
