package ru.angoldm.pm1.service.mapper;

import org.springframework.stereotype.Component;
import ru.angoldm.pm1.dto.TaskDto;
import ru.angoldm.pm1.entity.Task;

@Component
public class TaskMapper {

    public TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setBoardId(task.getBoardId());
        taskDto.setStatusId(task.getStatusId());
        taskDto.setAuthorId(task.getAuthorId());
        taskDto.setExecutorId(task.getExecutorId());
        taskDto.setDescr(task.getDescr());
        return taskDto;
    }

    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setBoardId(taskDto.getBoardId());
        task.setStatusId(taskDto.getStatusId());
        task.setAuthorId(taskDto.getAuthorId());
        task.setExecutorId(taskDto.getExecutorId());
        task.setDescr(taskDto.getDescr());
        return task;
    }
}
