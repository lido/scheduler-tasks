package com.lido.schedulertasks.business;


import com.lido.schedulertasks.business.dto.TasksDTO;
import com.lido.schedulertasks.business.mappers.TaskUpdateConverter;
import com.lido.schedulertasks.business.mappers.TasksConverter;
import com.lido.schedulertasks.infrastructure.entity.Tasks;
import com.lido.schedulertasks.infrastructure.enums.StatusNotification;
import com.lido.schedulertasks.infrastructure.exceptions.ResourceNotFoundException;
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
    private final TaskUpdateConverter taskUpdateConverter;
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

    public void deleteTasksById(String id){

        try {
            tasksRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Error deleting task by id, does not exist : ", e.getCause());
        }
    }

    public TasksDTO updateStatus(StatusNotification statusNotification, String id){
        try {
            Tasks tasks = tasksRepository.findById(id).orElseThrow(
                    ()->  new  ResourceNotFoundException("Task not found : "+id)
            );

            tasks.setStatusNotification(statusNotification);

            return tasksConverter.toTasksDTO(
                    tasksRepository.save(tasks));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Error updating status task ", e.getCause());
        }
    }

    public TasksDTO updateTasks(TasksDTO tasksDTO, String id){
        try {

            Tasks tasks = tasksRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Task not found : " + id)
            );
            taskUpdateConverter.updateTasks(tasksDTO, tasks);
            return tasksConverter.toTasksDTO(
                    tasksRepository.save(tasks));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Error updating task ", e.getCause());
        }

    }
}
