package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.ResourceRequirements;
import com.manage.spring_crud.services.ResourceRequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resourceReq")

public class ResourceRequirementsController {

    @Autowired
    private ResourceRequirementsService resourceRequirementsService;

    //Add new Resource Requirements
    @PostMapping("/addResourceRequirements")
    public ResourceRequirements addResourceRequirements(@RequestBody ResourceRequirements resourceRequirements) {
        System.out.println("Add called for 1 requirement");
        return resourceRequirementsService.addResourceRequirements(resourceRequirements);
    }

    // Add more than 1 Resource Requirements
    @PostMapping("/addResourcesRequirements")
    public List<ResourceRequirements> addAllResourceRequirements(@RequestBody List<ResourceRequirements> resourceRequirementsList ) {
        System.out.println("Add called for all requirements");
        return resourceRequirementsService.addAllResourceRequirements(resourceRequirementsList);
    }

    //Get Resource Requirements details by Id
    @GetMapping("/getResourceRequirementsByID/{id}")
    public ResourceRequirements getResourceRequirementsById(@PathVariable int id) {
        return resourceRequirementsService.getResourceRequirementsByID(id);
    }



    // Update Resource Requirements
    @PutMapping("/updateResourceRequirements")
    public ResourceRequirements updateResourceRequirements(@RequestBody ResourceRequirements resourceRequirements) {
        return resourceRequirementsService.updateResourceRequirements(resourceRequirements);
    }


    @DeleteMapping("/deleteResourceRequirements/{id}")
    // Delete Resource Requirements
    public boolean deleteResourceRequirements(@PathVariable int id) {
            return resourceRequirementsService.deleteResourceRequirements(id);
    }
    //Get all Resource REquirements Details
    @GetMapping("/getAllResourceRequirements")
    public List<ResourceRequirements> getAllResourceRequirements() {
        return resourceRequirementsService.getAllResourceRequirements();
    }
}
