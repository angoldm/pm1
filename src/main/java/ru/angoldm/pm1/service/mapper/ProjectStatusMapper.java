package ru.angoldm.pm1.service.mapper;

import org.springframework.stereotype.Component;
import ru.angoldm.pm1.dto.ProjectStatusDto;
import ru.angoldm.pm1.entity.ProjectStatus;

@Component
public class ProjectStatusMapper {

    public ProjectStatusDto toDto(ProjectStatus projectStatus) {
        ProjectStatusDto projectStatusDto = new ProjectStatusDto();
        projectStatusDto.setId(projectStatus.getId());
        projectStatusDto.setCode(projectStatus.getCode());
        projectStatusDto.setName(projectStatus.getName());
        return projectStatusDto;
    }

    public ProjectStatus toEntity(ProjectStatusDto projectStatusDto) {
        ProjectStatus projectStatus = new ProjectStatus();
        projectStatus.setId(projectStatusDto.getId());
        projectStatus.setCode(projectStatusDto.getCode());
        projectStatus.setName(projectStatusDto.getName());
        return projectStatus;
    }
}
