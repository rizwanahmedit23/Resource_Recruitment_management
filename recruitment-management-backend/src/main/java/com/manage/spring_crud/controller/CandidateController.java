package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.Candidate;
import com.manage.spring_crud.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    //Add new Candidate
    @PostMapping("/addCandidate")
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        System.out.println("Add called");
        return candidateService.addCandidate(candidate);
    }

    // Add more than 1 candidate
    @PostMapping("/addCandidates")
    public List<Candidate> addAllCandidates(@RequestBody List<Candidate> candidates) {
        return candidateService.addAllCandidates(candidates);
    }
//    @GetMapping("/abc")
//    public String getCandidabc() {
//        return "called";
//    }
    @GetMapping("/abc")
    public ResponseEntity<String> getCandidate() {
        return new ResponseEntity<>("{\"message\": \"called\"}", HttpStatus.OK);
    }

    //Get Candidate by Id
    @GetMapping("/getEmployeeByID/{id}")
    public Candidate getCandidateById(@PathVariable int id) {
        return candidateService.getCandidateByID(id);
    }

    //Get Candidate by Name
    @GetMapping("/getCandidateByName/{name}")
    public Candidate getCandidateByName(@PathVariable String name) {
        return candidateService.getCandidateByName(name);
    }

    // Update Candidate
    @PutMapping("/updateCandidate")
    public Candidate updateCandidate(@RequestBody Candidate candidate) {
        return candidateService.updateCandidate(candidate);
    }


    // Get all Candidates
    @GetMapping("/getCandidates")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();

    }

}
