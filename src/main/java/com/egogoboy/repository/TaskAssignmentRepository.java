package com.egogoboy.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.egogoboy.model.entity.TaskAssignmentEntity;

@ApplicationScoped
public class TaskAssignmentRepository {
    private EntityManager entityManager;

    @Inject
    public TaskAssignmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public TaskAssignmentEntity findById(Long id) {
        if (id == null) {
            return null;
        }

        TaskAssignmentEntity taskAssignment = entityManager.find(TaskAssignmentEntity.class, id);

        return taskAssignment;
    }

    public List<TaskAssignmentEntity> findByUserId(Long user_id) {
        if (user_id == null) {
            return null;
        }

        TypedQuery<TaskAssignmentEntity> query = entityManager.createQuery(
                "SELECT e FROM TaskAssignmentEntity e WHERE e.user_id == :user_id",
                TaskAssignmentEntity.class);

        return query.getResultList();
    }

    public List<TaskAssignmentEntity> findByTaskId(Long task_id) {
        if (task_id == null) {
            return null;
        }

        TypedQuery<TaskAssignmentEntity> query = entityManager.createQuery(
                "SELECT e FROM TaskAssignmentEntity e WHERE e.task_id == :task_id",
                TaskAssignmentEntity.class);

        return query.getResultList();
    }

    public List<TaskAssignmentEntity> findAll() {
        TypedQuery<TaskAssignmentEntity> query = entityManager.createQuery(
                "SELECT e FROM TaskAssignmentEntity e",
                TaskAssignmentEntity.class);

        return query.getResultList();
    }

    @Transactional
    public void save(TaskAssignmentEntity taskAssignment) {
        if (taskAssignment.getId() == null) {
            entityManager.persist(taskAssignment);
        } else {
            entityManager.merge(taskAssignment);
        }

        entityManager.flush();
    }

    @Transactional
    public void deleteById(Long id) {
        TaskAssignmentEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
