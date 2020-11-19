package com.didula.controller;

import com.didula.buisness.model.metadata.Test;
import com.didula.buisness.service.implementation.TestServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class TestController {
  public List<Test> getAllTests() throws SQLException {
    return new TestServiceImpl().findAll();
  }

  public Test getTest(Integer id) throws SQLException {
    return new TestServiceImpl().findById(id);
  }

  public int postTest(Test test) throws SQLException {
    return new TestServiceImpl().create(test);
  }

  public int putTest(Test test) throws SQLException {
    return new TestServiceImpl().update(test);
  }

  public int deleteTest(Integer id) throws SQLException {
    return new TestServiceImpl().delete(id);
  }
}
