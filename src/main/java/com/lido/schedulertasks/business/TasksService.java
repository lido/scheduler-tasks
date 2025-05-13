package com.lido.schedulertasks.business;


import com.lido.schedulertasks.business.dto.TasksDTO;
import com.lido.schedulertasks.business.mappers.TasksConverter;
import com.lido.schedulertasks.infrastructure.entity.Tasks;
import com.lido.schedulertasks.infrastructure.enums.StatusNotification;
import com.lido.schedulertasks.infrastructure.repository.TasksRepository;
import com.lido.schedulertasks.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;
    private final TasksConverter tasksConverter;
    private final JwtUtil jwtUtil;


    public TasksDTO registerTask(String token, TasksDTO tasksDTO){

        String email = jwtUtil.extractEmailToken(token.substring(7));

        tasksDTO.setDateOfCreation(LocalDateTime.now());
        tasksDTO.setStatusNotification(StatusNotification.PENDING);
        tasksDTO.setUserEmail(email);
        Tasks tasks = tasksConverter.toTasks(tasksDTO);

        return tasksConverter.toTasksDTO(
                tasksRepository.save(tasks)
        );
    }

    public List<TasksDTO> searchScheduledTasksByPeriod(LocalDateTime startDate, LocalDateTime finishDate){
        return tasksConverter.toListTasksDTO(
                tasksRepository.findByDateOfEventBetween(startDate, finishDate));
    }

    public List<TasksDTO> findByUserEmail(String token){

        String email = jwtUtil.extractEmailToken(token.substring(7));

        return  tasksConverter.toListTasksDTO(
                tasksRepository.findByUserEmail(email));
    }
}
