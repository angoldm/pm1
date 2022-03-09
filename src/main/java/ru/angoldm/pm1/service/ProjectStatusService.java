package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.ProjectStatusDto;
import java.util.List;

public interface ProjectStatusService {

    ProjectStatusDto createProjectStatus (ProjectStatusDto projectStatusDto);

    List<ProjectStatusDto> findAll();

    ProjectStatusDto updateProjectStatus (ProjectStatusDto projectStatusDto, Long id);

    void delete(Long id);
}
