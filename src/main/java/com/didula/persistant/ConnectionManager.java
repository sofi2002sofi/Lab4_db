package com.didula.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  private static final String username = "root";
  private static final String password = "14072002sdiot";
  private static final String url = "jdbc:mysql://localhost:3306/lab5_db?serverTimezone=UTC&useSQL=true";
  private static Connection connection = null;

  public static Connection getConnection() {
    if (connection == null) {
      try {
        connection = DriverManager.getConnection(url, username, password);
      } catch (SQLException throwables) {
        System.out.println("SQL Exception:" + throwables.getMessage());
        System.out.println("SQL State:" + throwables.getSQLState());
        System.out.println("Vendor Error:" + throwables.getErrorCode());
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException throwable) {
        System.out.println("Can't close connection, Exception is:" + throwable.getMessage());
        System.out.println("State:" + throwable.getMessage());
        System.out.println("Vendor Error:" + throwable.getMessage());
      }
    }
  }
}
