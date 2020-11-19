package com.didula.controller;

import com.didula.buisness.model.metadata.Message;
import com.didula.buisness.service.implementation.MessageServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class MessageController {
  public List<Message> getAllMessages() throws SQLException {
    return new MessageServiceImpl().findAll();
  }

  public Message getMessage(Integer id) throws SQLException {
    return new MessageServiceImpl().findById(id);
  }

  public int postMessage(Message message) throws SQLException {
    return new MessageServiceImpl().create(message);
  }

  public int putMessage(Message message) throws SQLException {
    return new MessageServiceImpl().update(message);
  }

  public int deleteMessage(Integer id) throws SQLException {
    return new MessageServiceImpl().delete(id);
  }
}
