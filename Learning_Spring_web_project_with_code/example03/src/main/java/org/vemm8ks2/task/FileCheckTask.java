package org.vemm8ks2.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.vemm8ks2.domain.BoardAttachVO;
import org.vemm8ks2.mapper.BoardAttachMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {

  @Autowired
  private BoardAttachMapper attachMapper;

  private String getFolderYesterDay() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);

    String str = sdf.format(cal.getTime());

    return str.replace("-", File.separator);
  }

  @Scheduled(cron = "0 0 2 * * *")
  public void checkFiles() throws Exception {

    log.warn("|| --- File Check Task run ...");
    log.warn("|| --- " + new Date());

    // file list in database
    List<BoardAttachVO> fileList = attachMapper.getOldFiles();

    // ready for check file in directory with database file list
    List<Path> fileListPaths =
        fileList.stream().map(vo -> Paths.get("C:\\upload", vo.getUploadPath(),
            "s_" + vo.getUuid() + "_" + vo.getFileName())).collect(Collectors.toList());

    // image file has thumnail file
    fileList
        .stream().filter(vo -> vo.isFileType()).map(vo -> Paths.get("C:\\upload",
            vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName()))
        .forEach(p -> fileListPaths.add(p));

    log.warn("||");

    fileListPaths.forEach(p -> log.warn(p));

    // files in yesterday directory
    File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
    File[] removeFiles = targetDir.listFiles(file -> !fileListPaths.contains(file.toPath()));

    log.warn("||");

    for (File file : removeFiles) {
      log.warn("|| --- " + file.getAbsolutePath());
      file.delete();
    }
  }
}
