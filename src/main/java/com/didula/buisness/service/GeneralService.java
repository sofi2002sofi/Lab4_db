package com.didula.buisness.service;

import com.didula.buisness.DAO.GeneralDAO;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T, ID> {
  GeneralDAO<T, ID> takeDAOObject();

  default List<T> findAll() throws SQLException {
    return takeDAOObject().findAll();
  }

  default T findById(ID id) throws SQLException {
    return takeDAOObject().findById(id);
  }

  default int create(T entity) throws SQLException {
    return takeDAOObject().create(entity);
  }

  default int update(T entity) throws SQLException {
    return takeDAOObject().update(entity);
  }

  default int delete(ID id) throws SQLException {
    return takeDAOObject().delete(id);
  }
}
