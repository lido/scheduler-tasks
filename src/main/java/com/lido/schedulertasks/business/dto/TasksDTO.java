package com.lido.schedulertasks.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lido.schedulertasks.infrastructure.enums.StatusNotification;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TasksDTO {

    private String id;
    private String nameTask;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateOfCreation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateOfEvent;
    private String userEmail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateOfChange;
    private StatusNotification statusNotification;

}
