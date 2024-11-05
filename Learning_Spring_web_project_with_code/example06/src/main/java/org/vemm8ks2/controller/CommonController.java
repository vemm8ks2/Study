package org.vemm8ks2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

  @GetMapping("/accessError")
  public void accessDenied(Authentication auth, Model model) {
    log.info("|| --- Access Denieid: " + auth);
    
    model.addAttribute("msg", "Access Denied");
  }
}
