package com.didula.controller;

import com.didula.buisness.model.metadata.User;
import com.didula.buisness.service.implementation.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class UserController {
  public List<User> getAllUsers() throws SQLException {
    return new UserServiceImpl().findAll();
  }

  public User getUser(Integer id) throws SQLException {
    return new UserServiceImpl().findById(id);
  }

  public int postUser(User user) throws SQLException {
    return new UserServiceImpl().create(user);
  }

  public int putUser(User user) throws SQLException {
    return new UserServiceImpl().update(user);
  }

  public int deleteUser(Integer id) throws SQLException {
    return new UserServiceImpl().delete(id);
  }
}
