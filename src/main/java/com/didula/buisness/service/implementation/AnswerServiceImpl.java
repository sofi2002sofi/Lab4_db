package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.AnswerDAO;
import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.implementation.AnswerDAOimpl;
import com.didula.buisness.model.metadata.Answer;
import com.didula.buisness.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {
  AnswerDAO entityDAO;

  @Override
  public GeneralDAO<Answer, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new AnswerDAOimpl();
    }
    return entityDAO;
  }
}
