package com.cognizant.springopenapidemo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

public class Student {

  @NotNull
  private String name;

  @Min(18)
  private Integer age;

  public Student(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
