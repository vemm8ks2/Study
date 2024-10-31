package org.vemm8ks2.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {

  @GetMapping("/uploadForm")
  public void uploadForm() {
    log.info("|| --- upload form");
  }

  @PostMapping("/uploadFormAction")
  public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

    String uploadFolder = "C:\\upload";

    for (MultipartFile multipartFile : uploadFile) {

      log.info("|| --- Upload File Name: " + multipartFile.getOriginalFilename());
      log.info("|| --- Upload File Size: " + multipartFile.getSize());

      File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

      try {
        multipartFile.transferTo(saveFile);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }

  @GetMapping("/uploadAjax")
  public void uploadAjax() {
    log.info("|| --- upload ajax");
  }
  
  @PostMapping("/uploadAjaxAction")
  public void uploadAjaxPost(MultipartFile[] uploadFile) {
    
    String uploadFolder = "C:\\upload";
    
    // make folder
    File uploadPath = new File(uploadFolder, getFolder());
    log.info("|| --- upload path: " + uploadPath);
    
    if (!uploadPath.exists()) {
      uploadPath.mkdirs(); // make yyyy/MM/dd folder
    }
    
    for (MultipartFile multipartFile : uploadFile) {
      
      log.info("||");
      log.info("|| --- Upload File Name: " + multipartFile.getOriginalFilename());
      log.info("|| --- Upload File Size: " + multipartFile.getSize());
      
      String uploadFileName = multipartFile.getOriginalFilename();
      
      // IE has file path
      uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
      log.info("|| --- Only file name: " + uploadFileName);
      
      File saveFile = new File(uploadPath, uploadFileName);
      
      try {
        multipartFile.transferTo(saveFile);
      } catch (Exception e) {
        log.error(e.getMessage());
      }
    }
  }
  
  private String getFolder() {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    Date date = new Date();
    String str = sdf.format(date);
    
    return str.replace("-", File.separator);
  }
}
