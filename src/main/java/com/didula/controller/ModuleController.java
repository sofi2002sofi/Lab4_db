package com.didula.controller;

import com.didula.buisness.model.metadata.Module;
import com.didula.buisness.service.implementation.ModuleServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class ModuleController {
  public List<Module> getAllModules() throws SQLException {
    return new ModuleServiceImpl().findAll();
  }

  public Module getModule(Integer id) throws SQLException {
    return new ModuleServiceImpl().findById(id);
  }

  public int postModule(Module module) throws SQLException {
    return new ModuleServiceImpl().create(module);
  }

  public int putModule(Module module) throws SQLException {
    return new ModuleServiceImpl().update(module);
  }

  public int deleteModule(Integer id) throws SQLException {
    return new ModuleServiceImpl().delete(id);
  }
}
