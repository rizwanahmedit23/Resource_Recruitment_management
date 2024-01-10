package com.manage.spring_crud.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResourceRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int requirementId;
    private String jobTitle;
    private String requiredSkills;
    private String minExperience;

    @OneToOne
    private Candidate candidate;
}

