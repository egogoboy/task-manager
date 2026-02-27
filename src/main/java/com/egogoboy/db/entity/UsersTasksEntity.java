package com.egogoboy.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users_tasks")
public class UsersTasksEntity {

    @Column
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;

    @Column
    @JoinColumn(name = "task_id", nullable = false)
    TaskEntity task;

}
