package com.didula;

import com.didula.persistant.ConnectionManager;
import com.didula.view.View;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
  public static void main(final String[] args) throws IOException, SQLException {
    new View().show();
    ConnectionManager.closeConnection();
  }
}
