package com.lido.schedulertasks.business.mappers;

import com.lido.schedulertasks.business.dto.TasksDTO;
import com.lido.schedulertasks.infrastructure.entity.Tasks;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskUpdateConverter {

    void updateTasks(TasksDTO dto, @MappingTarget Tasks entity);
}
