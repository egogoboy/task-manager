package com.egogoboy.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.egogoboy.model.entity.TaskEntity;

@ApplicationScoped
public class TaskRepository {
    EntityManager entityManager;

    @Inject
    TaskRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    TaskEntity findById(Long id) {
        if (id == null) {
            return null;
        }

        TaskEntity task = entityManager.find(TaskEntity.class, id);

        return task;
    }

    List<TaskEntity> findAll() {
        TypedQuery<TaskEntity> query = entityManager.createQuery(
                "SELECT e FROM TaskEntity e",
                TaskEntity.class);

        return query.getResultList();
    }

    @Transactional
    void save(TaskEntity task) {
        if (task.getId() == null) {
            entityManager.persist(task);
        } else {
            entityManager.merge(task);
        }

        entityManager.flush();
    }

    @Transactional
    void deleteById(Long id) {
        TaskEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
