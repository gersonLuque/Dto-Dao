package com.example.dto.persistence.implementatios;

import com.example.dto.persistence.entities.UserEntity;
import com.example.dto.persistence.interfaces.IUserDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
      return entityManager.createQuery("Select u from UserEntity u").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> findById(Long id) {
        return Optional.ofNullable(entityManager.find(UserEntity.class,id));
    }

    @Override
    @Transactional
    public void saveUser(UserEntity user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(UserEntity user) {
        entityManager.remove(user);
    }
}
