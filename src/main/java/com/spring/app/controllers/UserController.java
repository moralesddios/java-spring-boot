package com.spring.app.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.spring.app.models.UserModel;
import com.spring.app.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping()
  public ArrayList<UserModel> list(){
    return userService.list();
  }

  @PostMapping()
  public UserModel save(@RequestBody UserModel user){
    return userService.save(user);
  }

  @GetMapping( path = "/{id}" )
  public Optional<UserModel> getById(@PathVariable("id") Long id){
    return userService.getById(id);
  }

  @GetMapping("/query")
  public ArrayList<UserModel> findByPriority(@RequestParam("priority") Integer priority){
    return userService.findByPriority(priority);
  }

  @DeleteMapping( path = "/{id}" )
  public String deleteById(@PathVariable("id") Long id){
    boolean deleted = userService.delete(id);
    return deleted ? "Usuario eliminado correctamente." : "Usuario con id: " + id + " no encontrado.";
  }
}
