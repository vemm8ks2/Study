package org.vemm8ks2.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {

  @Insert("INSERT INTO tbl_sample2 (col2) VALUES (#{data})")
  public int insertCol2(String data);
}
