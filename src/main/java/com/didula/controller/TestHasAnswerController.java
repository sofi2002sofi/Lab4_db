package com.didula.controller;

import com.didula.buisness.model.metadata.TestHasAnswer;
import com.didula.buisness.service.implementation.TestHasAnswerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class TestHasAnswerController {
  public List<TestHasAnswer> getAllTestHasAnswers() throws SQLException {
    return new TestHasAnswerServiceImpl().findAll();
  }

  public TestHasAnswer getTestHasAnswer(Integer idTest, Integer idAnswer) throws SQLException {
    return new TestHasAnswerServiceImpl().findById(idTest, idAnswer);
  }

  public int postTestHasAnswer(TestHasAnswer testHasAnswer) throws SQLException {
    return new TestHasAnswerServiceImpl().create(testHasAnswer);
  }

  public int putTestHasAnswer(TestHasAnswer testHasAnswer) throws SQLException {
    return new TestHasAnswerServiceImpl().update(testHasAnswer);
  }

  public int deleteTestHasAnswer(Integer idTest, Integer idAnswer) throws SQLException {
    return new TestHasAnswerServiceImpl().delete(idTest, idAnswer);
  }
}
