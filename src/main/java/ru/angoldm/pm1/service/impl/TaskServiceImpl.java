package ru.angoldm.pm1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.angoldm.pm1.dto.TaskDto;
import ru.angoldm.pm1.entity.Task;
import ru.angoldm.pm1.exception.TaskIdNotFoundException;
import ru.angoldm.pm1.repository.TaskRepository;
import ru.angoldm.pm1.service.TaskService;
import ru.angoldm.pm1.service.mapper.TaskMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,
                           TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDto)));
    }

    @Override
    public List<TaskDto> findAll() {
        return taskRepository.findAll()
                .stream()
                .map((taskMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto, Long id) {
        if (!taskRepository.existsById(id)) throw new TaskIdNotFoundException(id);
        Task task = taskMapper.toEntity(taskDto);
        task.setId(id);
        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskIdNotFoundException(id));
        taskRepository.delete(task);
    }
}
