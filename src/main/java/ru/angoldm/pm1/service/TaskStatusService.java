package ru.angoldm.pm1.service;

import ru.angoldm.pm1.dto.TaskStatusDto;
import java.util.List;

public interface TaskStatusService {

    TaskStatusDto createTaskStatus (TaskStatusDto taskStatusDto);

    List<TaskStatusDto> findAll();

    TaskStatusDto updateTaskStatus (TaskStatusDto taskStatusDto, Long id);

    void delete(Long id);
}
