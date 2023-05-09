package com.cognizant.springopenapidemo.controller;

import com.cognizant.springopenapidemo.model.Drink;
import com.cognizant.springopenapidemo.model.Party;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/parties")
public class PartyController {

  @GetMapping
  public Party getParty(){
    return new Party("student party","Timisoara", List.of(new Drink("tequila",true)));
  }
}
