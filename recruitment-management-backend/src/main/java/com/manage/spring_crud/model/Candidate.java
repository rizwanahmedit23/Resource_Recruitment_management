package com.manage.spring_crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String contactNo;

    @OneToOne(mappedBy = "candidate")
    private InterviewFeedback1 interviewFeedback1;

    @OneToOne(mappedBy = "candidate")
    private InterviewFeedback2 interviewFeedback2;

    @OneToOne(mappedBy = "candidate")
    private HrDiscussion hrDiscussion;

    @OneToOne(mappedBy = "candidate")
    private ResourceRequirements resourceRequirements;

    @OneToOne(mappedBy = "candidate")
    private DiscussionDetails discussionDetails;
}
