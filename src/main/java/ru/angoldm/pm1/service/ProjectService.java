package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.ProjectDto;
import java.util.List;

public interface ProjectService {

    ProjectDto createProject(ProjectDto projectDto);

    List<ProjectDto> findAll();

    ProjectDto updateProject(ProjectDto projectDto, Long id);

    void delete(Long id);
}
