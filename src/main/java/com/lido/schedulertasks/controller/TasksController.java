package com.lido.schedulertasks.controller;

import com.lido.schedulertasks.business.TasksService;
import com.lido.schedulertasks.business.dto.TasksDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TasksController {

    private final TasksService tasksService;

    @PostMapping
    public ResponseEntity<TasksDTO> registerTasks(@RequestHeader("Authorization") String token,
                                             @RequestBody TasksDTO tasksDTO){
        return ResponseEntity.ok(tasksService.registerTask(token, tasksDTO));
    }
}
