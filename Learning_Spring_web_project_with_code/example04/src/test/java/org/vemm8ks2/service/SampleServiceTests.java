package org.vemm8ks2.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleServiceTests {

  @Autowired
  private SampleService service;

  @Test
  public void testClass() {

    log.info("service ==> " + service);
    log.info("service name ==> " + service.getClass().getName());
  }

  @Test
  public void testAdd() throws Exception {

    log.info(service.doAdd("123", "456"));
  }
}
