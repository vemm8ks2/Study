package com.vemm8ks2.sbb.answer;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.vemm8ks2.sbb.DataNotFoundException;
import com.vemm8ks2.sbb.question.Question;
import com.vemm8ks2.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

  private final AnswerRepository answerRepository;

  public void create(Question question, String content, SiteUser author) {
    Answer answer = new Answer();

    answer.setContent(content);
    answer.setCreateDate(LocalDateTime.now());
    answer.setQuestion(question);
    answer.setAuthor(author);

    answerRepository.save(answer);
  }
  
  public Answer getAnswer(Integer id) {
    
    Optional<Answer> answer = answerRepository.findById(id);
    
    if (answer.isPresent()) {
      return answer.get();
    } else {
      throw new DataNotFoundException("answer not found");
    }
  }
  
  public void modify(Answer answer, String content) {
    
    answer.setContent(content);
    answer.setModifyDate(LocalDateTime.now());
    
    answerRepository.save(answer);
  }
  
  public void delete(Answer answer) {
    answerRepository.delete(answer);
  }
  
  public void vote(Answer answer, SiteUser siteUser) {
    answer.getVoter().add(siteUser);
    answerRepository.save(answer);
  }
}
