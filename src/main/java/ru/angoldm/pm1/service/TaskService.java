package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.TaskDto;

import java.util.List;
public interface TaskService {

    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> findAll();

    void delete(Long id);
}
