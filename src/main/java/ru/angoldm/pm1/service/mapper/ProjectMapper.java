package ru.angoldm.pm1.service.mapper;

import org.springframework.stereotype.Component;
import ru.angoldm.pm1.dto.ProjectDto;
import ru.angoldm.pm1.entity.Project;

@Component
public class ProjectMapper {

    public ProjectDto toDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setStatusId(project.getStatusId());
        return projectDto;
    }

    public Project toEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setStatusId(projectDto.getStatusId());
        project.setName(projectDto.getName());
        return project;
    }
}
