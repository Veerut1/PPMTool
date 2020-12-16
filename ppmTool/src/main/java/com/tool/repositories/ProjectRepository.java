package com.tool.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tool.domain.Project;

@Repository
public interface ProjectRepository  extends CrudRepository<Project , Long>{

	Project findByProjectIdentifier(String projectId);
	
}
