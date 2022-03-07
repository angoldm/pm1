package ru.angoldm.pm1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.angoldm.pm1.dto.ProjectStatusDto;
import ru.angoldm.pm1.entity.ProjectStatus;
import ru.angoldm.pm1.exception.ProjectStatusIdNotFoundException;
import ru.angoldm.pm1.repository.ProjectStatusRepository;
import ru.angoldm.pm1.service.ProjectStatusService;
import ru.angoldm.pm1.service.mapper.ProjectStatusMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectStatusServiceImpl implements ProjectStatusService {

    private final ProjectStatusRepository projectStatusRepository;
    private final ProjectStatusMapper projectStatusMapper;

    @Autowired
    public ProjectStatusServiceImpl(ProjectStatusRepository projectStatusRepository,
                                    ProjectStatusMapper projectStatusMapper) {
        this.projectStatusRepository = projectStatusRepository;
        this.projectStatusMapper = projectStatusMapper;
    }

    @Override
    public ProjectStatusDto createProjectStatus(ProjectStatusDto projectStatusDto) {
        return projectStatusMapper.toDto(projectStatusRepository.save(projectStatusMapper.toEntity(projectStatusDto)));
    }

    @Override
    public List<ProjectStatusDto> findAll() {
        return projectStatusRepository.findAll()
                .stream()
                .map((projectStatusMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        ProjectStatus projectStatus = projectStatusRepository.findById(id)
                .orElseThrow(() -> new ProjectStatusIdNotFoundException(id));
        projectStatusRepository.delete(projectStatus);
    }
}
