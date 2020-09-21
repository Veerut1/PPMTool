package com.tool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tool.domain.Project;
import com.tool.exceptions.ProjectIdException;
import com.tool.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project  saveOrUpdateProject(Project project) {
		
		try {
			
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			
			return projectRepository.save(project);
		}catch(Exception e) {
			throw new ProjectIdException("Preject Id '"+project.getProjectIdentifier()+"' already exist.");
		}
		
	}

}
