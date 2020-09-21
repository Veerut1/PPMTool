package com.tool.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tool.domain.Project;
import com.tool.services.MapValidationErrorService;
import com.tool.services.ProjectService;

@RequestMapping("/api/project")
@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		
		if(errorMap!=null) return errorMap;
		
		Project project1 = projectService.saveOrUpdateProject(project);
		
		return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
	}
	
	
	
}
