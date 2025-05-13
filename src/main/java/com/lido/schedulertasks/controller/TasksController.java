package com.lido.schedulertasks.controller;

import com.lido.schedulertasks.business.TasksService;
import com.lido.schedulertasks.business.dto.TasksDTO;
import com.lido.schedulertasks.infrastructure.entity.Tasks;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/events")
    public ResponseEntity<List<TasksDTO>> searchScheduledTasksByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finishDate){

        return ResponseEntity.ok(tasksService.searchScheduledTasksByPeriod(startDate, finishDate));
    }

    @GetMapping
    public ResponseEntity<List<TasksDTO>> findByUserEmail(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(tasksService.findByUserEmail(token));
    }
}
