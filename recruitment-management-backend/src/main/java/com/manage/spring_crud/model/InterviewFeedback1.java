package com.manage.spring_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class InterviewFeedback1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int feedback1id;
    private String strengths;
    private String positionApplied;
    private String improvementAreas;

    @OneToOne
    private Candidate candidate;
}
