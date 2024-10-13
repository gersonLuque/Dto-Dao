package com.example.dto.service.implementation;

import com.example.dto.persistence.entities.UserEntity;
import com.example.dto.persistence.interfaces.IUserDao;
import com.example.dto.presentation.controller.dto.UserDTO;
import com.example.dto.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        // convierte un userentity a userdto o viceversa
        return iUserDao.findAll().stream()
                .map(entity -> modelMapper.map(entity,UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<UserEntity> userEntity = iUserDao.findById(id);
        if (userEntity.isPresent()){
            ModelMapper mp = new ModelMapper();
            UserEntity user = userEntity.get();
            return mp.map(user, UserDTO.class);
        }
        return null;
    }

    /*
    como es un metodo post se usa el dao para acceder a la base de datos
     */
    @Override
    public UserDTO createUser(UserDTO userDTO) { // userdto del request body
        ModelMapper mp = new ModelMapper();
        UserEntity userEntity = mp.map(userDTO,UserEntity.class);
        iUserDao.saveUser(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        Optional<UserEntity> userEntity = iUserDao.findById(id);
        if (userEntity.isPresent()){ // si el usuario existe en la base de datos
            UserEntity currentUserEntity = userEntity.get();
            currentUserEntity.setName(userDTO.getName());
            currentUserEntity.setAge(userDTO.getAge());
            currentUserEntity.setLastName(userDTO.getLastName());
            currentUserEntity.setAge(userDTO.getAge());

            iUserDao.updateUser(currentUserEntity);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(currentUserEntity, UserDTO.class);
        }


        return null;
    }

    @Override
    public String deleteUser(Long id) {
        Optional<UserEntity> userEntity = iUserDao.findById(id);
        if (userEntity.isPresent()){
            iUserDao.deleteUser(userEntity.get());
            return "Usuario con ID "+ id + " ha sido eliminado";
        }else
            return "Userio con id "+id+" no existe";
    }
}
