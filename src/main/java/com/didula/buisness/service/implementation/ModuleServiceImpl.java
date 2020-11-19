package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.ModuleDAO;
import com.didula.buisness.DAO.implementation.ModuleDAOimpl;
import com.didula.buisness.model.metadata.Module;
import com.didula.buisness.service.ModuleService;

public class ModuleServiceImpl implements ModuleService {
  ModuleDAO entityDAO;

  @Override
  public GeneralDAO<Module, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new ModuleDAOimpl();
    }
    return entityDAO;
  }
}
