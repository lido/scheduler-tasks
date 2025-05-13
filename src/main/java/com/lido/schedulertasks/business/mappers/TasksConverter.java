package com.lido.schedulertasks.business.mappers;

import com.lido.schedulertasks.business.dto.TasksDTO;
import com.lido.schedulertasks.infrastructure.entity.Tasks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TasksConverter {

    Tasks toTasks(TasksDTO tasksDTO);

    TasksDTO toTasksDTO(Tasks tasks);
}
