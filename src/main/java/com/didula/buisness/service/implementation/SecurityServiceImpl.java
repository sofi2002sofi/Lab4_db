package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.SecurityDAO;
import com.didula.buisness.DAO.implementation.SecurutyDAOimpl;
import com.didula.buisness.model.metadata.Security;
import com.didula.buisness.service.SecurityService;

public class SecurityServiceImpl implements SecurityService {
  SecurityDAO entityDAO;

  @Override
  public GeneralDAO<Security, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new SecurutyDAOimpl();
    }
    return entityDAO;
  }
}
