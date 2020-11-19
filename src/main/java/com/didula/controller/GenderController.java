package com.didula.controller;

import com.didula.buisness.model.metadata.Gender;
import com.didula.buisness.service.implementation.GenderServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class GenderController {
  public List<Gender> getAllGenders() throws SQLException {
    return new GenderServiceImpl().findAll();
  }

  public Gender getGender(Integer id) throws SQLException {
    return new GenderServiceImpl().findById(id);
  }

  public int postGender(Gender gender) throws SQLException {
    return new GenderServiceImpl().create(gender);
  }

  public int putGender(Gender gender) throws SQLException {
    return new GenderServiceImpl().update(gender);
  }

  public int deleteGender(Integer id) throws SQLException {
    return new GenderServiceImpl().delete(id);
  }
}
