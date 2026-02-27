package com.egogoboy.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.egogoboy.model.entity.UserEntity;

@ApplicationScoped
public class UserRepository {
    private EntityManager entityManager;

    @Inject
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserEntity findById(Long id) {
        if (id == null) {
            return null;
        }

        UserEntity user = entityManager.find(UserEntity.class, id);

        return user;
    }

    public List<UserEntity> findAll() {
        TypedQuery<UserEntity> query = entityManager.createQuery(
                "SELECT e FROM UserEntity e",
                UserEntity.class);

        return query.getResultList();
    }

    @Transactional
    public void save(UserEntity user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }

        entityManager.flush();
    }

    @Transactional
    public void deleteById(Long id) {
        UserEntity entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}
