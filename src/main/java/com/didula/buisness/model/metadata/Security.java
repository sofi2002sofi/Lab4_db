package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

@Table(name = "security")
public class Security {
  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "password", length = 8)
  private String password;

  @Column(name = "user_id", type = "int")
  private Integer userId;

  public Security() {

  }

  public Security(int id, String password, Integer userId) {
    this.id = id;
    this.password = password;
    this.userId = userId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {

    boolean equal = false;

    if (this == o) {
      equal = true;
    }

    if (o == null || getClass() != o.getClass()) {
      equal = false;
    }

    Security comperableSecurity = (Security) o;

    if (id != comperableSecurity.id) {
      equal = false;
    }

    if (!password.equals(comperableSecurity.password)) {
      equal = false;
    }

    if (!userId.equals(comperableSecurity.userId)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + password.hashCode();
    hashCode = 31 * hashCode + userId;
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %8s   %3s ", id, password, userId);
  }
}
