package com.didula.view;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public interface Printable {
  void print() throws SQLException, IOException, ParseException;
}
