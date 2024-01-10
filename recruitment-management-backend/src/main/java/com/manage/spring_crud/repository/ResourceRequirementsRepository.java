package com.manage.spring_crud.repository;

import com.manage.spring_crud.model.ResourceRequirements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRequirementsRepository extends JpaRepository<ResourceRequirements, Integer> {

}
