package com.egogoboy.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TaskAssignmentId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "task_id")
    private Long taskId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TaskAssignmentId that = (TaskAssignmentId) o;

        return that.userId == this.userId && that.taskId == this.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, taskId);
    }
}
