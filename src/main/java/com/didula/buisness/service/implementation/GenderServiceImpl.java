package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.GenderDAO;
import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.implementation.GenderDAOimpl;
import com.didula.buisness.model.metadata.Gender;
import com.didula.buisness.service.GenderService;

public class GenderServiceImpl implements GenderService {
  GenderDAO entityDAO;

  @Override
  public GeneralDAO<Gender, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new GenderDAOimpl();
    }
    return entityDAO;
  }
}
