package com.example.dto.presentation.controller;

import com.example.dto.presentation.controller.dto.UserDTO;
import com.example.dto.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/find")
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(iUserService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(iUserService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(iUserService.createUser(userDTO),HttpStatus.CREATED);
    }

    //update user
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        return new ResponseEntity<>(iUserService.updateUser(userDTO,id),HttpStatus.CREATED);
    }

    //dlete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(iUserService.deleteUser(id),HttpStatus.NO_CONTENT);
    }
}
