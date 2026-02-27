package com.egogoboy.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    Long id;

    @Column(nullable = false)
    String title;

    @Column
    String description;

    @Column(name = "start_time")
    Timestamp startTimestamp;

    @Column(name = "end_time")
    Timestamp endTimestamp;
}
