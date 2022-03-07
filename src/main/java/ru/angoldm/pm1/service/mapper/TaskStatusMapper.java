package ru.angoldm.pm1.service.mapper;

import org.springframework.stereotype.Component;
import ru.angoldm.pm1.dto.TaskStatusDto;
import ru.angoldm.pm1.entity.TaskStatus;

@Component
public class TaskStatusMapper {

    public TaskStatusDto toDto(TaskStatus taskStatus) {
        TaskStatusDto taskStatusDto = new TaskStatusDto();
        taskStatusDto.setId(taskStatus.getId());
        taskStatusDto.setCode(taskStatus.getCode());
        taskStatusDto.setName(taskStatus.getName());
        return taskStatusDto;
    }

    public TaskStatus toEntity(TaskStatusDto taskStatusDto) {
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setId(taskStatusDto.getId());
        taskStatus.setCode(taskStatusDto.getCode());
        taskStatus.setName(taskStatusDto.getName());
        return taskStatus;
    }
}
