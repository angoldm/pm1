package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.ProjectStatusDto;
import java.util.List;

public interface ProjectStatusService {

    ProjectStatusDto createProjectStatus (ProjectStatusDto projectStatusDto);

    List<ProjectStatusDto> findAll();

    void delete(Long id);
}
