package ru.angoldm.pm1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.angoldm.pm1.dto.ProjectDto;
import ru.angoldm.pm1.dto.TaskStatusDto;
import ru.angoldm.pm1.entity.Project;
import ru.angoldm.pm1.entity.TaskStatus;
import ru.angoldm.pm1.exception.ProjectIdNotFoundException;
import ru.angoldm.pm1.exception.TaskStatusIdNotFoundException;
import ru.angoldm.pm1.repository.TaskStatusRepository;
import ru.angoldm.pm1.service.TaskStatusService;
import ru.angoldm.pm1.service.mapper.TaskStatusMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {

    private final TaskStatusRepository taskStatusRepository;
    private final TaskStatusMapper taskStatusMapper;

    @Autowired
    public TaskStatusServiceImpl(TaskStatusRepository taskStatusRepository,
                                 TaskStatusMapper taskStatusMapper) {
        this.taskStatusRepository = taskStatusRepository;
        this.taskStatusMapper = taskStatusMapper;
    }

    @Override
    public TaskStatusDto createTaskStatus(TaskStatusDto taskStatusDto) {
        return taskStatusMapper.toDto(taskStatusRepository.save(taskStatusMapper.toEntity(taskStatusDto)));
    }

    @Override
    public List<TaskStatusDto> findAll() {
        return taskStatusRepository.findAll()
                .stream()
                .map((taskStatusMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public TaskStatusDto updateTaskStatus(TaskStatusDto taskStatusDto, Long id) {
        if (!taskStatusRepository.existsById(id)) throw new TaskStatusIdNotFoundException(id);
        TaskStatus taskStatus = taskStatusMapper.toEntity(taskStatusDto);
        taskStatus.setId(id);
        return taskStatusMapper.toDto(taskStatusRepository.save(taskStatus));
    }

    @Override
    public void delete(Long id) {
        TaskStatus taskStatus = taskStatusRepository.findById(id)
                .orElseThrow(() -> new TaskStatusIdNotFoundException(id));
        taskStatusRepository.delete(taskStatus);
    }
}
