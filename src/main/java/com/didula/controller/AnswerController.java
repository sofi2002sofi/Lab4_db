package com.didula.controller;

import com.didula.buisness.model.metadata.Answer;
import com.didula.buisness.service.implementation.AnswerServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class AnswerController {
  public List<Answer> getAllAnswers() throws SQLException {
    return new AnswerServiceImpl().findAll();
  }

  public Answer getAnswer(Integer id) throws SQLException {
    return new AnswerServiceImpl().findById(id);
  }

  public int postAnswer(Answer answer) throws SQLException {
    return new AnswerServiceImpl().create(answer);
  }

  public int putAnswer(Answer answer) throws SQLException {
    return new AnswerServiceImpl().update(answer);
  }

  public int deleteAnswer(Integer id) throws SQLException {
    return new AnswerServiceImpl().delete(id);
  }
}
