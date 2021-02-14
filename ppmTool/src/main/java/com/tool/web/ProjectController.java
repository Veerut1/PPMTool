package com.tool.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tool.domain.Project;
import com.tool.services.MapValidationErrorService;
import com.tool.services.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/api/project")
@RestController
@CrossOrigin
@Tag(name="Project",description="Project API")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	
	@Operation(summary ="Create project")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Project successfully created.")})
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result){
		
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		
		if(errorMap!=null) return errorMap;
		
		Project project1 = projectService.saveOrUpdateProject(project);
		
		return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
	}
	
	@Operation(summary ="Find project by id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "OK"),
							@ApiResponse(responseCode = "400",description = "Project not found.")})
	@GetMapping("/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable String projectId){
		
		Project project = projectService.findProjectByIdentifier(projectId);
		
		return new ResponseEntity<Project>(project , HttpStatus.OK);
		
	}
	
	
	@Operation(summary ="Find all projects")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "OK")})
	@GetMapping("/all")
	public Iterable<Project> getAllProjects(){
		
		return projectService.findAllProjects();
	}
	
	@Operation(summary ="Remove the project by id")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Successfully deleted.")})
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable String projectId){
		
		projectService.deleteProjectByIndentifier(projectId);
		
		return new ResponseEntity<String>("Project with ID '"+projectId+"' deleted successfully.",HttpStatus.OK);
	}
	
}
