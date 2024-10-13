package com.example.dto.service.interfaces;

import com.example.dto.presentation.controller.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO,Long id);
    String deleteUser(Long id);

}
