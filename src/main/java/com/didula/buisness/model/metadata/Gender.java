package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

@Table(name = "gender")
public class Gender {
  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "gender_name", length = 6)
  private String genderName;

  public Gender() {
  }

  public Gender(int id, String genderName) {
    this.id = id;
    this.genderName = genderName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGenderName() {
    return genderName;
  }

  public void setGenderName(String genderName) {
    this.genderName = genderName;
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

    Gender comperableGender = (Gender) o;

    if (id != comperableGender.id) {
      equal = false;
    }

    if (!genderName.equals(comperableGender.genderName)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + genderName.hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %15s ", id, genderName);
  }

}
