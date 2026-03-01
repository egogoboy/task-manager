package com.egogoboy.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.egogoboy.model.enums.AssignmentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tasks_assignment")
public class TaskAssignmentEntity {

    @EmbeddedId
    private TaskAssignmentId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @MapsId("taskId")
    @JoinColumn(name = "task_id", nullable = false)
    private TaskEntity task;

    @Enumerated(EnumType.STRING)
    @Column
    private AssignmentStatus status;

    @Column
    private LocalDateTime assignedAt;
}
