package com.didula.buisness.transformer;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transformer<T> {
  private final Class<T> clazz;

  public Transformer(Class<T> clazz) {
    this.clazz = clazz;
  }

  public Object fromResultSetToEntity(ResultSet rs) throws SQLException {
    Object entity = null;
    try {
      entity = clazz.getConstructor().newInstance();
      if (clazz.isAnnotationPresent(Table.class)) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
          if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            String name = column.name();
            String type = column.type();
            field.setAccessible(true);
            switch (type) {
              case "int":
                field.set(entity, rs.getInt(name));
                break;
              case "string":
                field.set(entity, rs.getString(name));
                break;
              case "double":
                field.set(entity, rs.getDouble(name));
                break;
              case "bool":
                field.set(entity, rs.getBoolean(name));
                break;
              case "BigDecimal":
                field.set(entity, rs.getBigDecimal(name));
                break;
              case "timestamp":
                field.set(entity, rs.getTimestamp(name));
                break;
              case "date":
                field.set(entity, rs.getDate(name));
                break;
              default:
                break;
            }
          }
        }
      }
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {
    }
    return entity;
  }
}
