package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.TestDAO;
import com.didula.buisness.DAO.implementation.TestDAOimpl;
import com.didula.buisness.model.metadata.Test;
import com.didula.buisness.service.TestService;

public class TestServiceImpl implements TestService {
  TestDAO entityDAO;

  @Override
  public GeneralDAO<Test, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new TestDAOimpl();
    }
    return entityDAO;
  }
}
