package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.implementation.TestHasAnswerDAOimpl;
import com.didula.buisness.model.metadata.TestHasAnswer;

import java.sql.SQLException;
import java.util.List;

public class TestHasAnswerServiceImpl {
  TestHasAnswerDAOimpl entityDAO;

  public TestHasAnswerDAOimpl takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new TestHasAnswerDAOimpl();
    }
    return entityDAO;
  }

  public List<TestHasAnswer> findAll() throws SQLException {
    return takeDAOObject().findAll();
  }

  public TestHasAnswer findById(Integer idTest, Integer idAnswer) throws SQLException {
    return takeDAOObject().findById(idTest, idAnswer);
  }

  public int create(TestHasAnswer entity) throws SQLException {
    return takeDAOObject().create(entity);
  }

  public int update(TestHasAnswer entity) throws SQLException {
    return takeDAOObject().update(entity);
  }

  public int delete(Integer idTest, Integer idAnswer) throws SQLException {
    return takeDAOObject().delete(idTest, idAnswer);
  }
}

