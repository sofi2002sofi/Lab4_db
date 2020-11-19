package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.MessageDAO;
import com.didula.buisness.DAO.implementation.MessageDAOimpl;
import com.didula.buisness.model.metadata.Message;
import com.didula.buisness.service.MessageService;

public class MessageServiceImpl implements MessageService {
  MessageDAO entityDAO;

  @Override
  public GeneralDAO<Message, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new MessageDAOimpl();
    }
    return entityDAO;
  }
}
