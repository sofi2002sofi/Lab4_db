package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.UserDAO;
import com.didula.buisness.DAO.implementation.UserDAOimpl;
import com.didula.buisness.model.metadata.User;
import com.didula.buisness.service.UserService;

public class UserServiceImpl implements UserService {
  UserDAO entityDAO;

  @Override
  public GeneralDAO<User, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new UserDAOimpl();
    }
    return entityDAO;
  }
}
