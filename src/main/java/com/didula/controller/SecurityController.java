package com.didula.controller;

import com.didula.buisness.model.metadata.Security;
import com.didula.buisness.service.implementation.SecurityServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class SecurityController {
  public List<Security> getAllSecurities() throws SQLException {
    return new SecurityServiceImpl().findAll();
  }

  public Security getSecurity(Integer id) throws SQLException {
    return new SecurityServiceImpl().findById(id);
  }

  public int postSecurity(Security security) throws SQLException {
    return new SecurityServiceImpl().create(security);
  }

  public int putSecurity(Security security) throws SQLException {
    return new SecurityServiceImpl().update(security);
  }

  public int deleteSecurity(Integer id) throws SQLException {
    return new SecurityServiceImpl().delete(id);
  }
}
