package com.lido.schedulertasks.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lido.schedulertasks.infrastructure.enums.StatusNotification;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("task")
public class Tasks {

    @Id
    private String id;
    private String nameTask;
    private String description;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfEvent;
    private String userEmail;
    private LocalDateTime dateOfChange;
    private StatusNotification statusNotification;
}
