package com.manage.spring_crud.services;

import com.manage.spring_crud.model.ResourceRequirements;
import com.manage.spring_crud.repository.ResourceRequirementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequirementsService {

    @Autowired
    private ResourceRequirementsRepository resourceRequirementsRepository;

    public ResourceRequirements addResourceRequirements(ResourceRequirements resourceRequirements) {
        return resourceRequirementsRepository.save(resourceRequirements);
    }

    public List<ResourceRequirements> addAllResourceRequirements(List<ResourceRequirements> resourceRequirementsList) {
        return resourceRequirementsRepository.saveAll(resourceRequirementsList);
    }

    public ResourceRequirements getResourceRequirementsByID(int id) {
        return resourceRequirementsRepository.findById(id).orElse(null);
    }

    public ResourceRequirements updateResourceRequirements(ResourceRequirements resourceRequirements) {
        ResourceRequirements exitingResourceReq = resourceRequirementsRepository.findById(resourceRequirements.getRequirementId()).orElse(null);

        if(exitingResourceReq == null) {
            return resourceRequirementsRepository.save(resourceRequirements);
        } else {
            resourceRequirementsRepository.deleteById(exitingResourceReq.getRequirementId());
            resourceRequirementsRepository.save(resourceRequirements);
        }
        return resourceRequirements;
    }

    public boolean deleteResourceRequirements(int id) {
        ResourceRequirements existingResourceRequirements = resourceRequirementsRepository.getReferenceById(id);
        if (existingResourceRequirements != null) {
            resourceRequirementsRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<ResourceRequirements> getAllResourceRequirements() {
        return resourceRequirementsRepository.findAll();
    }
}
