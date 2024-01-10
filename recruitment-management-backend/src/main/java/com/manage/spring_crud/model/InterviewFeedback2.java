package com.manage.spring_crud.model;

import jakarta.persistence.Entity;
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

public class InterviewFeedback2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feedback2id;
    private String projectExperience;
    private String advTechSkills;
    private String recommendation;

    @OneToOne
    private Candidate candidate;
}
