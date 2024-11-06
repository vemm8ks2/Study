package com.vemm8ks2.sbb.question;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

  private final QuestionRepository questionRepository;
  
  public List<Question> getList() {
    return questionRepository.findAll();
  }
}
