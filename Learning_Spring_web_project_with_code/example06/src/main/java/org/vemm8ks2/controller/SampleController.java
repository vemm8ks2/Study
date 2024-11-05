package org.vemm8ks2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

  @GetMapping("/all")
  public String doAll() {
    log.info("do all can access everybody");
    return "all";
  }
  
  @GetMapping("/member")
  public String doMember() {
    log.info("logged in member");
    return "member";
  }
  
  @GetMapping("/admin")
  public String doAdmin() {
    log.info("admin only");
    return "admin";
  }
}
