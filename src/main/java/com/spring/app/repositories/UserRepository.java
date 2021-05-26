package com.spring.app.repositories;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.spring.app.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
  public abstract ArrayList<UserModel> findByPriority(Integer priority);
}
