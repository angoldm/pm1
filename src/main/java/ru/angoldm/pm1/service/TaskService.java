package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.TaskDto;

import java.util.List;
public interface TaskService {

    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> findAll();

    TaskDto updateTask(TaskDto taskDto, Long id);

    void delete(Long id);
}
