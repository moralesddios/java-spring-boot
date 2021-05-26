package com.spring.app.services;

import java.util.Optional;
import java.util.ArrayList;

import com.spring.app.models.UserModel;
import com.spring.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public ArrayList<UserModel> list(){
    return (ArrayList<UserModel>) userRepository.findAll();
  }

  public UserModel save(UserModel user){
    return userRepository.save(user);
  }

  public Optional<UserModel> getById(Long id){
    return userRepository.findById(id);
  }

  public ArrayList<UserModel> findByPriority(Integer priority){
    return userRepository.findByPriority(priority);
  }

  public boolean delete(Long id){
    try{
      userRepository.deleteById(id);
      return true;
    } catch(Exception e){
      return false;
    }
  }
}
