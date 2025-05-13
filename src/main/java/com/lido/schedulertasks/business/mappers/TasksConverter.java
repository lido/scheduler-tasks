package com.lido.schedulertasks.business.mappers;

import com.lido.schedulertasks.business.dto.TasksDTO;
import com.lido.schedulertasks.infrastructure.entity.Tasks;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TasksConverter {

    Tasks toTasks(TasksDTO tasksDTO);

    TasksDTO toTasksDTO(Tasks tasks);

    List<Tasks> toListTasks(List<TasksDTO> tasksDTOs);

    List<TasksDTO> toListTasksDTO(List<Tasks> tasks);
}
