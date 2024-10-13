package com.example.dto.persistence.interfaces;

import com.example.dto.persistence.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDao {
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    void saveUser(UserEntity user);
    void updateUser(UserEntity user);
    void deleteUser(UserEntity user);

}
