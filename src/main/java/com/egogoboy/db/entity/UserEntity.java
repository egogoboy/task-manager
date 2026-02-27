package com.egogoboy.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class UserEntity {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String username;

    @Column
    String hashPassword;

    @Column
    String role;
}
