package projects.service;
import java.util.List;


import java.util.NoSuchElementException;

import entity.Project;
import projects.dao.ProjectDao;
import projects.exeption.DbException;


public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();
	
	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}

	public List<Project> fetchAllProjects() {
//		fetchAllProjects();
		return projectDao.fetchAllProjects();
	}

	public Project fetchProjectById(Integer projectId) {		
		return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException("Project"
				+ "with project ID=" + projectId + "does not exist."));
				
	}
/* The DAO method returns a boolean that indicates whether the UPDATE operation was successful. 
/*Check the return value. If it is false, throw a DbException with a message that says the 
 * project does not exist.*/
	
	public void modifyProjectDetails(Project project) {
		if( !projectDao.modifyProjectDetails(project)) {
		throw new DbException("Project with ID = " + project.getProjectId() + "does not exist");
	}

	}

	public void deleteProject(Integer projectId) {
		if(!projectDao.deleteProject(projectId)) {
			throw new DbException("Project with ID " + projectId + "does not exist");
		}
		
	}
}