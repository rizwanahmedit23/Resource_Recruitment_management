package com.manage.spring_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DiscussionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int discussionId;
    private String discussionDate;
    private String discussionNotes;

    @OneToOne
    private Candidate candidate;
}

