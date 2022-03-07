package ru.angoldm.pm1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.angoldm.pm1.dto.ProjectDto;
import ru.angoldm.pm1.entity.Project;
import ru.angoldm.pm1.exception.ProjectIdNotFoundException;
import ru.angoldm.pm1.repository.ProjectRepository;
import ru.angoldm.pm1.service.ProjectService;
import ru.angoldm.pm1.service.mapper.ProjectMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository,
                          ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        return projectMapper.toDto(projectRepository.save(projectMapper.toEntity(projectDto)));
    }

    @Override
    public List<ProjectDto> findAll() {
        return projectRepository.findAll()
                .stream()
                .map((projectMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectIdNotFoundException(id));
        projectRepository.delete(project);
    }
}
