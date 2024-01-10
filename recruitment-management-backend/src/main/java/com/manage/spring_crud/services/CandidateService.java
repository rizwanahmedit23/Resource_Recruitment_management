package com.manage.spring_crud.services;

import com.manage.spring_crud.model.Candidate;
import com.manage.spring_crud.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate addCandidate(Candidate candidate) {
        System.out.println("Add candidate called");
        return candidateRepository.save(candidate);
    }

    public List<Candidate> addAllCandidates(List<Candidate> candidates) {
        return candidateRepository.saveAll(candidates);
    }

    public Candidate getCandidateByID(int id) {
        return candidateRepository.findById(id).orElse(null);

    }


    public Candidate getCandidateByName(String name) {
        return candidateRepository.findByName(name);
    }

    public Candidate updateCandidate(Candidate candidate) {
        Candidate exitingCand = candidateRepository.findById(candidate.getId()).orElse(null);

        if(exitingCand == null) {
            return candidateRepository.save(candidate);
        } else {
            candidateRepository.deleteById(exitingCand.getId());
            candidateRepository.save(candidate);
        }
        return candidate;
    }
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}
