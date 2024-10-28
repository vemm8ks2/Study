package org.vemm8ks2.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.vemm8ks2.domain.Criteria;
import org.vemm8ks2.domain.ReplyVO;

public interface ReplyMapper {

  public int insert(ReplyVO vo);

  public ReplyVO read(Long rno); // Ư�� ��� �б�

  public int delete(Long rno);

  public int update(ReplyVO reply);

  public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
