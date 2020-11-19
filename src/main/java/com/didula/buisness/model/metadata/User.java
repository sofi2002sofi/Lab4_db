package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

@Table(name = "user")
public class User {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "full_name", length = 50)
  private String fullName;

  @Column(name = "forums_name", length = 50)
  private String forumsName;

  @Column(name = "email", length = 50)
  private String email;

  @Column(name = "birth_year", type = "int")
  private int birthYear;

  @Column(name = "gender_id", type = "int")
  private Integer genderId;

  public User() {
  }

  public User(int id, String fullName, String forumsName, String email, int birthYear, Integer genderId) {
    this.id = id;
    this.fullName = fullName;
    this.forumsName = forumsName;
    this.email = email;
    this.birthYear = birthYear;
    this.genderId = genderId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getForumsName() {
    return forumsName;
  }

  public void setForumsName(String forumsName) {
    this.forumsName = forumsName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public Integer getGenderId() {
    return genderId;
  }

  public void setGenderId(Integer genderId) {
    this.genderId = genderId;
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

    User comperableUser = (User) o;

    if (id != comperableUser.id) {
      equal = false;
    }

    if (!fullName.equals(comperableUser.fullName)) {
      equal = false;
    }

    if (!forumsName.equals(comperableUser.forumsName)) {
      equal = false;
    }

    if (!email.equals(comperableUser.email)) {
      equal = false;
    }

    if (birthYear != comperableUser.birthYear) {
      equal = false;
    }

    if (!genderId.equals(comperableUser.genderId)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + fullName.hashCode();
    hashCode = 31 * hashCode + forumsName.hashCode();
    hashCode = 31 * hashCode + email.hashCode();
    hashCode = 31 * hashCode + birthYear;
    hashCode = 31 * hashCode + genderId;
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %50s   %50s   %30s   %4s   %6s ", id, fullName, forumsName, email, birthYear, genderId);
  }
}
