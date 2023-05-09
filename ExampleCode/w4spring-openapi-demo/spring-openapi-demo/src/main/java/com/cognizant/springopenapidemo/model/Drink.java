package com.cognizant.springopenapidemo.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

public class Drink {
  @NotNull
  private String drinkName;
  private boolean isAlcoholic;

  public Drink(String drinkName, boolean isAlcoholic) {
    this.drinkName = drinkName;
    this.isAlcoholic = isAlcoholic;
  }

  public String getDrinkName() {
    return drinkName;
  }

  public boolean isAlcoholic() {
    return isAlcoholic;
  }

  public void setDrinkName(String drinkName) {
    this.drinkName = drinkName;
  }

  public void setAlcoholic(boolean alcoholic) {
    isAlcoholic = alcoholic;
  }
}
